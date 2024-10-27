package com.kodilla.exception.test;

public class SecondChallenge {
    public String propablyIWillThrowException(double x, double b) throws Exception {
        if (x >= 2 || x < 1 || b == 1.5) {
            throw new Exception();
        }
        return "Done!";

    }
}
