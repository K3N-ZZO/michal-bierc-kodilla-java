package com.kodilla.good.patterns.food2door;

public class OrderService {
    public void order(Producer producer, DeliveryService deliveryService, Product product, int quantity) {
        boolean isProcessed = producer.process(product, quantity);
        if (isProcessed) {
            deliveryService.deliver(product, quantity);
        }
    }
}
