package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Producer {
    @Override
    public boolean process(Product product, int quantity) {
        System.out.println("Processing order in HealthyShop for " + quantity + " of " + product.getName());

        return true;
    }
}
