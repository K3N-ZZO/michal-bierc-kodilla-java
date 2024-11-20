package com.kodilla.spring;

import com.kodilla.spring.reader.Reader;
import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ReaderTestSuite {
    @Test
    void testRead(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);
        //When & Then
        reader.read();
    }
    @Test
    void testConditional(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        boolean condition = context.containsBean("book2");
        System.out.println("Bean book2 was found in the container: " + condition);
    }
}
