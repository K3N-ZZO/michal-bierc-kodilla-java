package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser user = new SimpleUser("Kodilla");
        String result = user.getUsername();

        if (result.equals("Kodilla")) {
            System.out.println("Test ok");
        } else {
            System.out.println("Test failed");
        }
        Calculator calculator = new Calculator();
        calculator.CalculatorAdd(10,50);
        calculator.CalculatorSub(50,10);

    }
}
