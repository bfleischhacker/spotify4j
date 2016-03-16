package org.spotify4j.generation;

import org.spotify4j.generation.java.AccessModifier;
import org.spotify4j.generation.java.JavaClass;
import org.spotify4j.generation.java.JavaDocComment;
import org.spotify4j.generation.java.JavaEnum;
import org.spotify4j.generation.java.JavaField;
import org.spotify4j.generation.java.JavaMethod;
import org.spotify4j.generation.java.types.GenericType;
import org.spotify4j.generation.java.types.JavaTypes;
import org.spotify4j.generation.java.types.PrimitiveType;
import org.spotify4j.generation.java.types.ReferenceType;
import org.spotify4j.generation.java.types.Type;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RamlFile {
    public final String fileName;
    public final String type;
    public final String description;
    public final String displayName;
    private Map<Object, Object> properties;
    public final String pattern;
    private Map<String, String> propertyNameOverrides;

    public static final Yaml YAML = new Yaml();

    private static final HashMap<String, Type> RamlTypeToJavaTypeMap;

    static {
        RamlTypeToJavaTypeMap = new HashMap<>();
        RamlTypeToJavaTypeMap.put("string", JavaTypes.String);
        RamlTypeToJavaTypeMap.put("integer", PrimitiveType.Int);
        RamlTypeToJavaTypeMap.put("number", PrimitiveType.Double);
        RamlTypeToJavaTypeMap.put("boolean", JavaTypes.Boolean);
    }

    public RamlFile(String fileName, String type, String description, String displayName, Map<Object, Object> properties, String pattern) {
        this.fileName = fileName;
        this.type = type;
        this.description = description;
        this.displayName = displayName;
        this.properties = properties;
        this.pattern = pattern;
        this.propertyNameOverrides = new HashMap<>();
    }

    public static RamlFile parse(Path path) throws FileNotFoundException {
        final Map<String, Object> yaml = YAML.loadAs(new FileReader(path.toFile()), Map.class);
        return new RamlFile(
                path.getFileName().toString(),
                (String) yaml.get("type"),
                (String) yaml.get("description"),
                (String) yaml.get("displayName"),
                (Map<Object, Object>) yaml.getOrDefault("properties", new HashMap<>()),
                (String) yaml.get("pattern"));
    }


    protected void parseProperty(String packageName, JavaClass containing, Map.Entry<Object, Object> property) {
        if (property.getKey() instanceof ArrayList) {
            System.out.println("Encounterd enum type defintion of " + fileName);
            return;
        }

        String propertyName = (String) property.getKey();
        String propertyMemberName = propertyNameOverrides.getOrDefault(propertyName, propertyName);
        final String typeName;
        final String baseTypeName;
        final boolean isRequired;
        final JavaDocComment description;
        Type type = null;

        if (property.getKey() instanceof String && property.getValue() instanceof String) {
            typeName = (String) property.getValue();
            baseTypeName = typeName.replace("[]", "");
            isRequired = true;
            description = null;
        } else if (property.getKey() instanceof String && property.getValue() instanceof Map) {
            final Map<String, Object> propertyFields = (Map<String, Object>) property.getValue();
            typeName = (String) propertyFields.get("type");
            isRequired = (boolean) propertyFields.getOrDefault("required", true);
            description = new JavaDocComment((String) propertyFields.get("description"));
            baseTypeName = typeName.replace("[]", "");
            if (baseTypeName.equals("Page")) {
                String innerTypeName = (String) propertyFields.get("(pagedObject)");
                type = new GenericType("Page", packageName, new ReferenceType(innerTypeName, packageName));
            } else if (baseTypeName.equals("string") && propertyFields.containsKey("enum")) {
                final List<String> values = (List<String>) propertyFields.get("enum");
                String enumName = Util.snakeToCamelCase(propertyName);
                containing.getEnums().add(new JavaEnum(enumName, values));
                type = new ReferenceType(enumName, packageName.isEmpty() ?
                        getClassName() :
                        packageName + "." + getClassName());
            }
        } else {
            return;
        }

        if (type == null) {
            if (RamlTypeToJavaTypeMap.containsKey(baseTypeName)) {
                type = RamlTypeToJavaTypeMap.get(baseTypeName);
            } else {
                type = new ReferenceType(baseTypeName, packageName);
            }
        }

        if (typeName.endsWith("[]")) {
            type = JavaTypes.List(type);
        }

        if (!isRequired) {
            type = JavaTypes.Optional(type);
        }

        containing.getVariables().add(
                new JavaField(AccessModifier.PRIVATE, false, false, Util.snakeToLowerCamelCase(propertyMemberName), type)
                        .withComment(description));
    }


    private String getClassName() {
        return Util.snakeToCamelCase(fileName.substring(0, fileName.length() - 5));
    }

    private boolean isEnum() {
        return properties.keySet().stream().findFirst().map(o -> (o instanceof ArrayList)).orElse(false);
    }

    private void buildConstructor(JavaClass javaClass) {
        final List<JavaField> superClassFields = javaClass.getSuperClass() == null ? new ArrayList<>() :
                javaClass.getSuperClass()
                        .getMethods()
                        .stream()
                        .filter(m -> m.returnType == null) //constructors
                        .findFirst().map(Stream::of).orElse(Stream.empty())
                        .flatMap(m -> m.params.stream())
                        .collect(Collectors.toList());

        final Stream<String> superConstructor = javaClass.getSuperClass() == null ? Stream.empty() :
                Stream.of(superClassFields.stream().map(JavaField::getName).collect(Collectors.joining(", ", "super(", ");")));

        final List<JavaField> settableFields = javaClass.getVariables().stream().filter(v -> !v.isStatic()).collect(Collectors.toList());

        final List<JavaField> params = Stream.concat(superClassFields.stream(), settableFields.stream()).collect(Collectors.toList());

        final List<String> assignments = Stream.concat(
                superConstructor,
                settableFields.stream().map(f -> String.format("this.%s = %s;", f.getName(), f.getName()))
        ).collect(Collectors.toList());

        javaClass.getMethods().add(0, new JavaMethod(
                pattern != null ? AccessModifier.PROTECTED : AccessModifier.PUBLIC,
                false,
                null,
                getClassName(),
                params,
                assignments
        ));
    }

    private void buildEmptyConstructor(JavaClass javaClass) {

        final ArrayList<String> body = new ArrayList<>();
        if (javaClass.getSuperClass() != null) {
            body.add("super();");
        }
        javaClass.getMethods().add(0, new JavaMethod(
                pattern != null ? AccessModifier.PROTECTED : AccessModifier.PUBLIC,
                false,
                null,
                getClassName(),
                new ArrayList<>(),
                body
        ));
    }

    private void buildAccessors(JavaClass javaClass) {
        javaClass.getVariables().stream()
                .filter(v -> !v.isStatic() && v.getModifier() != AccessModifier.PUBLIC)
                .forEach(field -> {
                    javaClass.getMethods().add(new JavaMethod(
                            AccessModifier.PUBLIC,
                            false,
                            field.getType(),
                            "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
                            new ArrayList<>(),
                            Stream.of(String.format("return %s;", field.getName())).collect(Collectors.toList())
                    ));
                    if (!field.isFinal()) {
                        javaClass.getMethods().add(new JavaMethod(
                                AccessModifier.PUBLIC,
                                false,
                                javaClass.getType(),
                                "with" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
                                Stream.of(field).collect(Collectors.toList()),
                                Stream.of(
                                        String.format("this.%s = %s;", field.getName(), field.getName()),
                                        String.format("return this;", field.getName())
                                ).collect(Collectors.toList())
                        ));
                    }
                });
    }

    private void buildStringWrapper(JavaClass clazz) {
        String fieldName = clazz.getName().substring(0, 1).toLowerCase() + clazz.getName().substring(1);
        JavaField valueField = new JavaField(AccessModifier.PRIVATE, false, true, fieldName, JavaTypes.String);
        clazz.getVariables().add(valueField);

        if (pattern != null) {
            clazz.getVariables().add(
                    new JavaField(AccessModifier.PRIVATE, true, true, "PATTERN", new ReferenceType("Pattern", "java.util.regex"))
                            .withAssignment("Pattern.compile(\"" + pattern + "\")"));


            clazz.getMethods().add(new JavaMethod(
                    AccessModifier.PUBLIC,
                    true,
                    JavaTypes.Optional(clazz.getType()),
                    "verify",
                    Stream.of(valueField).collect(Collectors.toList()),
                    Stream.of(String.format("return PATTERN.matcher(%s).matches() ? ", fieldName),
                            String.format("Optional.of(new %s(%s)) : ", clazz.getName(), fieldName),
                            "Optional.empty();").collect(Collectors.toList()))
            );
        }
    }

    public Optional<String> getParentType() {
        return type.equals("string") || type.equals("object") ? Optional.empty() : Optional.of(type);
    }


    public JavaClass toClass(String packagePath, Map<String, JavaClass> classPath) {
        JavaClass clazz = new JavaClass(getClassName(), packagePath);
        clazz.withComment(new JavaDocComment(description));

        if (type.equals("string")) {
            buildStringWrapper(clazz);
        } else {
            if (!type.equals("object")) {
                assert (classPath.containsKey(type));
                clazz.withSuperClass(classPath.get(type));
            }
            for (Map.Entry<Object, Object> prop : properties.entrySet()) {
                parseProperty(packagePath, clazz, prop);
            }
            buildEmptyConstructor(clazz);
        }

        buildConstructor(clazz);
        buildAccessors(clazz);

        return clazz;
    }

    public RamlFile withPropertyNameOverride(String name, String alternative) {
        this.propertyNameOverrides.put(name, alternative);
        return this;
    }
}
