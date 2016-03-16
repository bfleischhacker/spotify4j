package org.spotify4j.generation.java.types;

public class JavaTypes {
    public static final ReferenceType String = new ReferenceType("String", "java.lang");
    public static final ReferenceType Integer = new ReferenceType("Int", "java.lang");
    public static final ReferenceType Double = new ReferenceType("Double", "java.lang");
    public static final ReferenceType Boolean = new ReferenceType("Boolean", "java.lang");

    public static GenericType Map(Type keyType, Type valueType) {
        return new GenericType("Map", "java.util", keyType, valueType);
    }

    public static GenericType List(Type type) {
        return new GenericType("List", "java.util", type);
    }

    public static final GenericType Optional(Type type) {
        return new GenericType("Optional", "java.util", type);
    }
}
