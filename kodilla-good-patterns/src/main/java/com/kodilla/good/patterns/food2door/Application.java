package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        Producer extraFoodShop = new ExtraFoodShop();
        Producer healthyShop = new HealthyShop();
        Producer glutenFreeShop = new GlutenFreeShop();

        DeliveryService courierDelivery = new CourierDelivery();
        DeliveryService droneDelivery = new DroneDelivery();

        Product apples = new Product("Apples", 2.5);
        Product bananas = new Product("Bananas", 1.8);
        Product carrots = new Product("Carrots", 1.2);

        orderService.order(extraFoodShop, courierDelivery, apples, 10);
        orderService.order(healthyShop, droneDelivery, bananas, 20);
        orderService.order(glutenFreeShop, courierDelivery, carrots, 30);
    }
}
