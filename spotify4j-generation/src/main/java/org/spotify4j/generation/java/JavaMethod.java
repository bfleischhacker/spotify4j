package org.spotify4j.generation.java;

import org.spotify4j.generation.java.types.ReferenceType;
import org.spotify4j.generation.java.types.Type;
import org.spotify4j.generation.writing.LineWriter;
import org.spotify4j.generation.writing.PrefixedLineWriter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaMethod {
    public final AccessModifier modifier;
    public final boolean isStatic;
    public final Type returnType;
    public final String name;
    public List<JavaField> params;
    private final List<String> body;
    public final HashSet<Type> references;

    Pattern END_OF_TYPE = Pattern.compile("(:?\\$)([a-zA-Z0-9\\.]+\\.([a-zA-Z0-9]+))");

    public JavaMethod(AccessModifier modifier, boolean isStatic, Type returnType, String name, List<JavaField> params, List<String> body) {
        this.modifier = modifier;
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.body = body;
        this.references = new HashSet<>();

        for (int i = 0; i < body.size(); i++) {
            final Matcher matcher = END_OF_TYPE.matcher(body.get(i));
            while (matcher.find()) {
                references.add(new ReferenceType(matcher.group(0), matcher.group(1)));
            }
            body.set(i, body.get(i).replaceAll(END_OF_TYPE.pattern(), "$1"));
        }
    }

    public void write(LineWriter writer) throws IOException {
        writer.writeLine(String.format("%s%s%s %s(%s) {",
                modifier.name().toLowerCase(),
                isStatic ? " static " : " ",
                returnType != null ? returnType.getDeclaration() : "",
                name,
                params.stream()
                        .map(f -> String.format("%s %s", f.getType().getDeclaration(), f.getName()))
                        .collect(Collectors.joining(", ")))
        );
        final PrefixedLineWriter bodyWriter = new PrefixedLineWriter("  ", writer);
        for (String line : body) {
            bodyWriter.writeLine(line);
        }
        writer.writeLine("}");
    }
}
