package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "London");
        FindFlight findFlight = new FindFlight();

        try {
            boolean canFly = findFlight.findFlight(flight);
            System.out.println("Flight available: " + canFly);
        } catch (RouteNotFoundException e) {
            System.out.println("Flight not found: " + e);
        } finally {
            System.out.println("Looking for flights finished!");
        }
    }
}
