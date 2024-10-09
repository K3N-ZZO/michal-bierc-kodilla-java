package com.kodilla.testing.shape;

public class Square implements Shape {

    private double side;
    @Override
    public String getShapeName() {
        return "Square";
    }

    public Square(double side){
        this.side = side;
    }
    @Override
    public double getField() {
        return side * side;
    }
}
