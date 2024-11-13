package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;


public class Order {
    String productName;
    int quantity;
    String deliveryAddress;
    LocalDate dateOfOrder;

    public Order(String productName, int quantity, String deliveryAddress, LocalDate dateOfOrder) {
        this.productName = productName;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
        this.dateOfOrder = dateOfOrder;
    }
}
