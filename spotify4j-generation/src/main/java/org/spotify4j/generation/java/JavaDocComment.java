package org.spotify4j.generation.java;

import org.spotify4j.generation.writing.LineWriter;
import org.spotify4j.generation.writing.PrefixedLineWriter;

import java.io.IOException;

public class JavaDocComment {
    private String description;

    public JavaDocComment(String description) {
        this.description = description;
    }

    public void write(LineWriter lineWriter) throws IOException {
        if(description != null && !description.isEmpty()) {
            PrefixedLineWriter boxWriter = new PrefixedLineWriter(" * ", lineWriter);
            lineWriter.writeLine("/**");
            if (description != null) {
                for (String line : description.split("\n")) {
                    boxWriter.writeLine(line);
                }
            }
            lineWriter.writeLine(" **/");
        }
    }
}
