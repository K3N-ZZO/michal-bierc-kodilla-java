package com.kodilla.spring;

import com.kodilla.spring.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations(){
        //Given
        //When
        double addResult = calculator.add(10.0,2.0);
        double subResult = calculator.sub(10.0,2.0);
        double divResult = calculator.div(10.0,2.0);
        double mulResult = calculator.mul(10.0,2.0);
        //Then
        assertEquals(addResult,12.0);
        assertEquals(subResult,8.0);
        assertEquals(divResult,5.0);
        assertEquals(mulResult,20.0);
    }
}
