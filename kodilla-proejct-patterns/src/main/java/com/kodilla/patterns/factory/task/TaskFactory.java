package com.kodilla.patterns.factory.task;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task createTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Buy groceries", "Milk", 2.0);
            case PAINTING -> new PaintingTask("Paint a wall", "Blue", "Living Room Wall");
            case DRIVING -> new DrivingTask("Drive to work", "Office", "Car");
            default -> null;
        };
    }
}
