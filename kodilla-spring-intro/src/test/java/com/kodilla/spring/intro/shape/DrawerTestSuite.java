package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {

    @Test
    void testDoCircle(){
        Shape circle = new Circle();

        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        assertEquals("This is a circle", result);
    }
    @Test
    void testDoTriangle(){
        Shape triangle = new Triangle();

        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        assertEquals("This is a triangle", result);
    }
}
