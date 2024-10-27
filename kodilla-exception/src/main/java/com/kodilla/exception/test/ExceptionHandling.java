package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public ExceptionHandling(double x, double b) {
        SecondChallenge sc = new SecondChallenge();
        try {
            String result = sc.propablyIWillThrowException(x, b);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception caught " + e);
        } finally {
            System.out.println("End");
        }
    }
}
