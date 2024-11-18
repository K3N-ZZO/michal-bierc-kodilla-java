package com.kodilla.good.patterns.food2door;

public class CourierDelivery implements DeliveryService {
    @Override
    public boolean deliver(Product product, int quantity) {
        System.out.println("Delivering " + quantity + " of " + product.getName() + " by courier.");

        return true;
    }
}
