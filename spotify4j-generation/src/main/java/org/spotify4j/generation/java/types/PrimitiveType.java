package org.spotify4j.generation.java.types;

import java.util.ArrayList;
import java.util.List;

public enum PrimitiveType implements Type {
    Int("int", JavaTypes.Integer),
    Double("double", JavaTypes.Double),
    Boolean("boolean", JavaTypes.Boolean);

    PrimitiveType(String name, ReferenceType boxed) {
        this.name = name;
        this.boxed = boxed;
    }

    private final String name;
    private final ReferenceType boxed;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDeclaration() {
        return getName();
    }

    @Override
    public String getPackage() {
        return "";
    }

    @Override
    public List<Type> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public ReferenceType boxed() {
        return boxed;
    }

}

