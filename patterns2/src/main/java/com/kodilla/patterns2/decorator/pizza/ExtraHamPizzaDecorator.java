package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraHamPizzaDecorator extends AbstractPizzaOrderDecorator{
    public ExtraHamPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("6"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
