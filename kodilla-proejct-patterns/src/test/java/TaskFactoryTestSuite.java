package com.kodilla.patterns.factory.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        // When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        // Then
        assertEquals("Buy groceries", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        // When
        Task painting = factory.createTask(TaskFactory.PAINTING);
        painting.executeTask();
        // Then
        assertEquals("Paint a wall", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        // When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        driving.executeTask();
        // Then
        assertEquals("Drive to work", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
