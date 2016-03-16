package org.spotify4j.generation.java;

import org.spotify4j.generation.writing.LineWriter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JavaEnum {
    public final String name;
    private List<String> values;

    public JavaEnum(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    public void write(LineWriter writer) throws IOException {
        writer.writeLine(String.format("public enum %s { %s }", name, values.stream().collect(Collectors.joining(", "))));
    }

}
