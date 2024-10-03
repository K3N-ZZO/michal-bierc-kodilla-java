package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import java.util.*;



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
    @DisplayName("When Odd numbers list is empty and only should remains")
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
    @DisplayName("When class contains odd and even numbers")
    @Test
    void testOddNumbersExterminatorNonEmptyList() {
        //Given

        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> nonEmptyList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenResult = Arrays.asList(2,4,6,8,10);

        //When

        List<Integer> nonEmptyResult = exterminator.exterminate(nonEmptyList);

        //Then

        Assertions.assertEquals(evenResult,nonEmptyResult);
    }
}

