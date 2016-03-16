package org.spotify4j.generation;

import org.spotify4j.generation.java.JavaClass;
import org.spotify4j.generation.writing.BasicLineWriter;
import org.spotify4j.generation.writing.LineWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String packagePath = "org.spotify4j.models";
        final Path objectModelsRoot = Paths.get(Main.class.getClassLoader().getResource("").toURI().resolve("spotify-web-api/specifications/raml/libraries/objectModels"));
        final Path typesRoot = Paths.get(Main.class.getClassLoader().getResource("").toURI().resolve("spotify-web-api/specifications/raml/types"));
        final Path output = Paths.get("./spotify4j-core/src/main/java/org/spotify4j/models").toAbsolutePath();
        Files.createDirectories(output);
        Set<Path> ignored = Stream.concat(
                Stream.of("objects.raml", "_page.raml", "_base_page.raml", "_cursor_page.raml").map(objectModelsRoot::resolve),
                Stream.of("types.raml").map(typesRoot::resolve)
        ).collect(Collectors.toSet());

        final List<RamlFile> ramlFiles = Stream.concat(Files.list(objectModelsRoot), Files.list(typesRoot))
                .filter(f -> !ignored.contains(f)).map(f -> {
                    try {
                        return RamlFile.parse(f);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());


        //Process parent classes first
        final HashMap<String, JavaClass> classPath = new HashMap<>();
        Queue<RamlFile> ramlQueue = new LinkedBlockingQueue<>(ramlFiles);
        while (!ramlQueue.isEmpty()) {
            final RamlFile next = ramlQueue.remove();
            if (!next.getParentType().isPresent() || classPath.containsKey(next.getParentType().get())) {
                System.out.println("generating " + next.fileName);
                final JavaClass javaClass = next
                        .withPropertyNameOverride("public", "isPublic")
                        .toClass(packagePath, classPath);
                LineWriter out = new BasicLineWriter(Files.newOutputStream(output.resolve(javaClass.getName() + ".java")));
                javaClass.write(out);
                classPath.put(javaClass.getName(), javaClass);
            } else {
                ramlQueue.add(next);
                System.out.println("skipping " + next.fileName + " for now");
            }
        }
    }
}
