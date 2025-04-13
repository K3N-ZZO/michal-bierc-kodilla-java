package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraPepperoniPizzaDecorator extends AbstractPizzaOrderDecorator{
    public ExtraPepperoniPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("9"));
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " + pepperoni";
    }
}
