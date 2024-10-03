package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class CollectionTestSuite {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Test case begin: ");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("Test case end: ");
    }
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test suite begin: ");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Test suite end: ");
    }
    @Test
    void testOddNumbersExterminatorEmptyList() {
        // Given
            List<Integer> emptyList = new ArrayList<>();
            OddNumbersExterminator exterminator = new OddNumbersExterminator();

        // When
            List<Integer> result = exterminator.exterminate(emptyList);

        // Then
            Assertions.assertTrue(result.isEmpty());
    }
    @Test
    void testOddNumbersExterminatorNonEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> nonEmptyList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            nonEmptyList.add(i);
        }
        //When
        List<Integer> nonEmptyResult = exterminator.exterminate(nonEmptyList);

        //Then
        Assertions.assertTrue(nonEmptyResult.isEmpty());
    }
}

