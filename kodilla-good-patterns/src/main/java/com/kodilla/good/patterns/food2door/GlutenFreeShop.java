package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Supplier {
    @Override
    public String process(Order order) {
        if (order.productName.equals("mąka bezglutenowa") && order.quantity <= 10) {
            return "Zamówienie na " + order.quantity + "kg mąki bezglutenowej  zostało zrealizowane pomyślnie " +
                    "przez GlutenFreeShop";
        } else {
            return "Produkt niedostępny lub zamówiono zbyt dużą ilość! ";
        }
    }
}
