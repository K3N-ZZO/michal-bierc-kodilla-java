package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public void executeExpression(double a, double b, MathExpression mathExpression) {
        double result = mathExpression.calculateExpression(5,10);
        System.out.println("Result equals" + result);
    }
}
