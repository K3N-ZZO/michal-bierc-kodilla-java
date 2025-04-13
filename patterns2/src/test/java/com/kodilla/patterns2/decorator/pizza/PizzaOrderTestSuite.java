package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrder() {
        PizzaOrder order = new BasicPizzaOrder();
        assertEquals(new BigDecimal(15), order.getPrice());
        assertEquals("Pizza with tomato sauce and cheese", order.getDescription());
    }

    @Test
    void testPizzaWithHamAndMushrooms() {
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraHamPizzaDecorator(order);
        order = new ExtraMushroomsPizzaDecorator(order);

        assertEquals(new BigDecimal(24), order.getPrice());
        assertEquals("Pizza with tomato sauce and cheese + ham + mushrooms", order.getDescription());
    }

    @Test
    void testFullDeluxePizza() {
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraMushroomsPizzaDecorator(order);
        order = new ExtraCheesePizzaDecorator(order);
        order = new ExtraHamPizzaDecorator(order);
        order = new ExtraPepperoniPizzaDecorator(order);

        assertEquals(new BigDecimal(38), order.getPrice());
        assertEquals("Pizza with tomato sauce and cheese + mushrooms extra cheese + ham + pepperoni", order.getDescription());
    }
}

