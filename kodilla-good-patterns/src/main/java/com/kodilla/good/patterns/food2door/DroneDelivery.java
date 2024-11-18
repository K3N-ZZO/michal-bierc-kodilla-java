package com.kodilla.good.patterns.food2door;

public class DroneDelivery implements DeliveryService {
    @Override
    public boolean deliver(Product product, int quantity) {
        System.out.println("Delivering " + quantity + " of " + product.getName() + " by drone.");

        return true;
    }
}
