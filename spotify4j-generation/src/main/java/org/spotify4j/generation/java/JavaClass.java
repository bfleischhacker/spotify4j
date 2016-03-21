package org.spotify4j.generation.java;

import org.spotify4j.generation.java.types.ReferenceType;
import org.spotify4j.generation.writing.LineWriter;
import org.spotify4j.generation.writing.PrefixedLineWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class JavaClass {
    String name;
    String packageName;
    private JavaDocComment comment;
    private JavaClass superClass;
    private Set<JavaField> variables;
    private Set<JavaEnum> enums;
    private List<JavaMethod> methods;

    public JavaClass(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
        this.variables = new HashSet<>();
        this.enums = new HashSet<>();
        this.methods = new ArrayList<>();
    }

    public ReferenceType getType() {
        return new ReferenceType(name, packageName);
    }

    private void writePackageDefinition(LineWriter lineWriter) throws IOException {
        lineWriter.writeLine(String.format("package %s;", packageName));
    }

    protected Set<String> getPackageDependencies() {
        Set<String> packages = new HashSet<>();
        if (variables != null) {
            variables.stream()
                    .flatMap(v -> Stream.of(
                            v.getAnnotations().stream().map(t -> t.type),
                            Stream.of(v.getType()),
                            v.getType().getChildren().stream())).flatMap(Function.identity())
                    //filter out our own child enums
                    .filter(tpe -> !enums.stream().filter(e -> e.name.equals(tpe.getName())).findAny().isPresent())
                    .filter(t -> t.getPackage() != null && !t.getPackage().isEmpty())
                    .map(t -> String.format("%s.%s", t.getPackage(), t.getName()))
                    .forEach(packages::add);
        }
        if (methods != null) {
            methods.stream()
                    .flatMap(m -> Stream.of(
                            m.references.stream(),
                            Stream.of(m.returnType),
                            m.params.stream().map(JavaField::getType)).flatMap(Function.identity()))
                    .filter(t -> t != null && t.getPackage() != null && !t.getPackage().isEmpty())
                    .map(t -> String.format("%s.%s", t.getPackage(), t.getName()))
                    .forEach(packages::add);
        }

        packages.remove("");
        return packages;
    }

    private void writeImports(LineWriter lineWriter) throws IOException {
        for (String importedPackage : getPackageDependencies()) {
            lineWriter.writeLine(String.format("import %s;", importedPackage));
        }
    }

    protected void writeMemberVariableDeclarations(LineWriter lineWriter) throws IOException {
        if (variables != null) {
            for (JavaField variable : variables) {
                if (variable.getComment() != null) {
                    variable.getComment().write(lineWriter);
                }
                for (JavaAnnotation javaAnnotation : variable.getAnnotations()) {
                    lineWriter.writeLine(javaAnnotation.getDeclaration());
                }
                lineWriter.writeLine(variable.getDeclaration());
            }
        }
    }

    protected void writeInnerClassDefinitions(LineWriter lineWriter) throws IOException {
        if (enums != null) {
            for (JavaEnum child : enums) {
                child.write(lineWriter);
                lineWriter.writeLine("");
            }
        }
    }

    protected String getClassDefinitionName() {
        return name;
    }

    private void writeClassDefinition(LineWriter lineWriter) throws IOException {
        LineWriter indentedLineWriter = new PrefixedLineWriter("  ", lineWriter);

        String extendsModifier = superClass != null ? " extends " + superClass.getName() : "";
        String implementsModifier = "";
        lineWriter.writeLine(String.format("public class %s%s%s {", getClassDefinitionName(), extendsModifier, implementsModifier));
        writeMemberVariableDeclarations(indentedLineWriter);
        lineWriter.writeLine("");
        writeInnerClassDefinitions(indentedLineWriter);
        writeMethodDefinitions(indentedLineWriter);
        lineWriter.writeLine("}");

    }

    private void writeMethodDefinitions(LineWriter lineWriter) throws IOException {
        if (methods != null) {
            for (JavaMethod method : methods) {
                method.write(lineWriter);
            }
        }
    }

    public void write(LineWriter lineWriter) throws IOException {
        writePackageDefinition(lineWriter);
        lineWriter.writeLine("");
        writeImports(lineWriter);
        lineWriter.writeLine("");
        lineWriter.writeLine("");
        if (comment != null) {
            comment.write(lineWriter);
        }
        writeClassDefinition(lineWriter);
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public JavaDocComment getComment() {
        return comment;
    }

    public JavaClass withComment(JavaDocComment comment) {
        this.comment = comment;
        return this;
    }

    public JavaClass getSuperClass() {
        return superClass;
    }

    public JavaClass withSuperClass(JavaClass superClass) {
        this.superClass = superClass;
        return this;
    }

    public Set<JavaField> getVariables() {
        return variables;
    }

    public JavaClass withVariables(Set<JavaField> variables) {
        this.variables = variables != null ? variables : new HashSet<>();
        return this;
    }

    public Set<JavaEnum> getEnums() {
        return enums;
    }

    public JavaClass withEnums(Set<JavaEnum> childClasses) {
        this.enums = childClasses != null ? childClasses : new HashSet<>();
        return this;
    }

    public List<JavaMethod> getMethods() {
        return methods;
    }

    public JavaClass withMethods(ArrayList<JavaMethod> methods) {
        this.methods = methods != null ? methods : new ArrayList<>();
        return this;
    }
}
