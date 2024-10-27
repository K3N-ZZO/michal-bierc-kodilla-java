package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {
    @Test
    void testReadFile() {
        //Given
        FileReader fr = new FileReader();
        String filename = "nie_ma_takiego_pliku.txt";
        //when & then
        assertThrows(FileReaderException.class, () -> fr.readFile(filename));
    }
    @Test
    void testReadFileWithName(){
        FileReader fr = new FileReader();
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fr.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fr.readFile(null)),
                () -> assertDoesNotThrow(() -> fr.readFile("names.txt"))

        );
    }
}
