package com.kodilla.good.patterns.challenges;

public class MemoryOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Product product) {
        System.out.println(" Tworzę zamówienie dla : " + user.getName() + " z produktem: " + product.getProductName());
    }
}
