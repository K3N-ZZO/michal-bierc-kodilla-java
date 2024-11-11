package com.kodilla.good.patterns.challenges;

public class Main {
    public static void main(String[] args) {
        User user = new User(" Jan Kowalski ", " jankowalski@wp.pl ");
        Product product = new Product(" Szczoteczka do zębów ", 13.99);

        OrderRequest orderRequest = new OrderRequest(user, product);

        InformationService informationService = new EmailInformationService();
        OrderService orderService = new SimpleOrderService();
        OrderRepository orderRepository = new MemoryOrderRepository();


        OrderProcessor orderProcessor = new OrderProcessor(informationService, orderService, orderRepository);

        OrderDto orderDto = OrderProcessor.process(orderRequest);
        System.out.println(" Podsumowanie zamówienia: " + orderDto);
    }
}
