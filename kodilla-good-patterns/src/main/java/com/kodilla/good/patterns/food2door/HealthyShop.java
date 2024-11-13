package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Supplier{
    @Override
    public String process(Order order) {
        if (order.productName.equals("banany") && order.quantity <= 10) {
            return "Zamówienie na " + order.quantity + " bananów zostało zrealizowane pomyślnie przez HealthyShop";
        } else {
            return "Produkt niedostępny lub zamówiono zbyt dużą ilość! ";
        }
    }
}
