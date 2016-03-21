package org.spotify4j.generation.java;

import org.spotify4j.generation.java.types.Type;

import java.util.List;
import java.util.stream.Collectors;

public class JavaAnnotation {
    public final Type type;
    public final List<String> params;

    public JavaAnnotation(Type type, List<String> params) {
        this.type = type;
        this.params = params;
    }

    public String getDeclaration() {
        String paramsStr = params != null && !params.isEmpty() ?
                params.stream().collect(Collectors.joining(", ", "(", ")")) : "";
        return String.format("@%s%s", type.getDeclaration(), paramsStr);
    }
}
