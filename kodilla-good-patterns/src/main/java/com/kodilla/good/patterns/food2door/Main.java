package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Supplier extraFoodShop = new ExtraFoodShop();
        Supplier glutenFreeShop = new GlutenFreeShop();
        Supplier healthyShop = new HealthyShop();

        Order order1 = new Order("jabłka", 5, "ul. Słowackiego 12",
                LocalDate.of(2021,11,12));
        Order order2 = new Order("banany",3, "ul. Kościuszki 105a",
                LocalDate.of(2019,05,29));
        Order order3 = new Order("mąka bezglutenowa", 10,"ul. zielona 1",
                LocalDate.of(2024,01,15));

        System.out.println(extraFoodShop.process(order1));
        System.out.println(glutenFreeShop.process(order3));
        System.out.println(healthyShop.process(order2));
    }
}
