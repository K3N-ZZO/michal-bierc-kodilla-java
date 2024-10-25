package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide (double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static void main(String[] args) {
        FirstChallenge f = new FirstChallenge();
        try {
            double result = f.divide(3.0, 1.0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Wystapil blad! " + e);
        }
    }
}
