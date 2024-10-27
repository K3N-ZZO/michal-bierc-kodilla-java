package com.kodilla.exception.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile(final String filename) throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (Stream<String> fileLines = Files.lines(Path.of(classLoader.getResource(filename).toURI()))) {
            fileLines.forEach(System.out::println);
        } catch (Exception e) {
            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
