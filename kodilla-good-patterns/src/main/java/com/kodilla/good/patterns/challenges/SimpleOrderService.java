package com.kodilla.good.patterns.challenges;

public class SimpleOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product) {
        System.out.println("Zamawiam produkt: " + product.getProductName() + " dla użytkownika " + user.getName() );
        return true;
    }
}
