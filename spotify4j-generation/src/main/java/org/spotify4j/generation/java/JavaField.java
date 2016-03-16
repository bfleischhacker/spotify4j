package org.spotify4j.generation.java;

import org.spotify4j.generation.java.types.Type;

public class JavaField {
    private JavaDocComment comment;
    private AccessModifier modifier;
    private boolean isStatic;
    private boolean isFinal;
    private String name;
    private Type type;
    private String assignment;

    public JavaField(AccessModifier modifier, boolean isStatic, boolean isFinal, String name, Type type) {
        this.modifier = modifier;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.name = name;
        this.type = type;
    }

    public String getDeclaration() {
        return String.format("%s%s%s%s %s%s;",
                modifier.name().toLowerCase(),
                isStatic ? " static " : " ",
                isFinal ? " final " : " ",
                type.getDeclaration(),
                name,
                assignment != null ? " = " + assignment : "").replace("  ", " ");
    }

    public AccessModifier getModifier() {
        return modifier;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public Type getType() {
        return type;
    }

    public JavaDocComment getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public JavaField withComment(JavaDocComment comment) {
        this.comment = comment;
        return this;
    }

    public JavaField withAssignment(String assignment) {
        this.assignment = assignment;
        return this;
    }
}

