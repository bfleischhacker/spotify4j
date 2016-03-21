package org.spotify4j.generation.java;


import org.spotify4j.generation.java.types.ReferenceType;

import java.util.ArrayList;

public class Annotations {
    private static ReferenceType JacksonJsonPropertyAnnotation =
            new ReferenceType("JsonProperty", "com.fasterxml.jackson.annotation");

    public static JavaAnnotation GsonSerializedName(String fieldName) {
        final ArrayList<String> params = new ArrayList<>();
        params.add("\"" + fieldName + "\"");
        return new JavaAnnotation(JacksonJsonPropertyAnnotation, params);
    }
}
