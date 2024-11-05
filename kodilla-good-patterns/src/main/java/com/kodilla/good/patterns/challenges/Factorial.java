package com.kodilla.good.patterns.challenges;

public class Factorial {
    public static int factorialCalculate(int n){
        if (n == 0){
            return 1;
        }
        return n * factorialCalculate(n -1);

    }
}
