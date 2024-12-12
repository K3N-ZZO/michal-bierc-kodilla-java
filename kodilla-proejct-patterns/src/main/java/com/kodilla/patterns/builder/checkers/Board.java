package com.kodilla.patterns.builder.checkers;

public class Board {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private final Figure[][] board = new Figure[10][0];

    public Board() {
        for (int i = 0; i < 10; i++) {
            board[i] = new Figure[10];
        }
    }

    public Figure getFigure(int row, int col) {
        return board[row][col];
    }
    public void setFigure(int row, int col, Figure figure) {
        board[row][col] = figure;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
            result.append("|");
            for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
                if (board[x][y] == null) {
                    result.append("  ");
                } else {
                    result.append((board[x][y]).getColor().equals(Figure.BLACK) ? "b" : "w");
                    result.append((board[x][y]) instanceof Pawn ? "P" : "Q");
                }
                result.append("|");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
