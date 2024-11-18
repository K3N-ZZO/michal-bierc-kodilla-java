package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Producer {
    @Override
    public boolean process(Product product, int quantity) {
        System.out.println("Processing order in ExtraFoodShop for " + quantity + " of " + product.getName());

        return true;
    }
}
