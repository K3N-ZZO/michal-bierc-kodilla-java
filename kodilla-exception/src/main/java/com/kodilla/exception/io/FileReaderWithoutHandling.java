package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {
    public void readFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        Path path = Paths.get("psuje.txt");
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getAbsolutePath()))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! " +e);
        } finally {
            System.out.println("I'm gonna be here... always!");
        }
        System.out.println(file.getPath());
    }
}
