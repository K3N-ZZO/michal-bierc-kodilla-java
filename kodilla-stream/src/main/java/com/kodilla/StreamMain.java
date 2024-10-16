package com.kodilla;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;


import java.nio.channels.AsynchronousByteChannel;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10,5, (a,b) -> a + b);
        expressionExecutor.executeExpression(10,5,(a,b) -> a-b);
        expressionExecutor.executeExpression(10,5,(a,b) -> a/b);
        expressionExecutor.executeExpression(10,5,(a,b) -> a*b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3,4,FunctionalCalculator::subtractAFromB);
        expressionExecutor.executeExpression(3,4,FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(3,4,FunctionalCalculator::multiplyAByB);


        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Simple text", text -> "Abc" + text + "Abc");
        poemBeautifier.beautify("Simple text", String::toLowerCase);
        poemBeautifier.beautify("Simple text", text -> "###" + text + "###");
        poemBeautifier.beautify("Simple text", text -> text.replace("e", "3"));

        System.out.println("Using stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
