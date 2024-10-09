package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
   ArrayList<Shape> ShapeList = new ArrayList<>();
   public void addFigure(Shape shape) {
       ShapeList.add(shape);
    }
    public void removeFigure(Shape shape){
        ShapeList.remove(shape);

    }
    public Shape getFigure(int n){
        if (n >= 0 && n < ShapeList.size()) {
            return ShapeList.get(n);
        }
        return null;
    }
    public String showFigures() {
        StringBuilder names = new StringBuilder();
        for (Shape shape : this.ShapeList) {
            if (names.length() > 0) {
                names.append(", ");
            }
            names.append(shape.getShapeName());
        }
        return names.toString();
    }
}
