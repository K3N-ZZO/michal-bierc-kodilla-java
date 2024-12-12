package com.kodilla.patterns.builder.checkers;

public class FigureFactory {

    public static final String PAWN = "Pawn";
    public static final String QUEEN = "Queen";

    public static Figure makeFigure(String figureType, String color) {
        if (figureType.equals(PAWN)) {
            return new Pawn(color);
        }
        else if (figureType.equals(QUEEN)) {
            return new Queen(color);
        } else {
            throw new IllegalStateException("Figure type " + figureType + " not supported");
        }
    }
}
