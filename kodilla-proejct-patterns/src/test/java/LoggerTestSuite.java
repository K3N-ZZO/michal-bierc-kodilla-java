package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testLog(){
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("First log");
        //When
        String result = logger.getLastLog();
        //Then
        assertEquals("First log",result);
    }
    @Test
    void testLogUpdate(){
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("First log");
        logger.log("Second log");
        //Then
        String result = logger.getLastLog();
        //When
        assertEquals("Second log",result);
    }
}
