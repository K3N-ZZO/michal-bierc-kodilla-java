package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: ShapeCollector Test Suite: ")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("This is the end of tests.");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    class TestAddAndRemove {
        @DisplayName("Testing adding figure to collection")
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5);
            //When
            shapeCollector.addFigure(square);
            //Then
            Assertions.assertEquals(1,shapeCollector.ShapeList.size());
        }

        @DisplayName("Testing removing figure from collection")
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(10);
            //When
            shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertEquals(0,shapeCollector.ShapeList.size());
        }
    }
    @Nested
    class TestOperationsOnCollection {
        @DisplayName("Testing getting figure by index")
        @Test
        void getFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(35.5, 10);
            shapeCollector.addFigure(triangle);
            //When
            Object result = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(triangle, result);

        }

        @DisplayName("Test showing all figures as string")
        @Test
        void showFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5);
            Shape circle = new Circle(10);
            Shape triangle1 = new Triangle(11, 50);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle1);

            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Square, Circle, Triangle", result);
        }
    }
}
