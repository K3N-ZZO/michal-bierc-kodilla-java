package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Supplier{
    @Override
    public String process(Order order) {
        if (order.productName.equals("jabłka") && order.quantity <= 10) {
            return "Zamówienie na " + order.quantity + " jabłek zostało zrealizowane pomyślnie przez ExtraFoodShop";
        } else {
            return "Produkt niedostępny lub zamówiono zbyt dużą ilość! ";
        }
    }
}
