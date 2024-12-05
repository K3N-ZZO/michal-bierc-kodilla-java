package com.kodilla.good.patterns.Flights;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FlightServiceTestSuite {
    @Test
    void testFindFlightsFrom() {
        // Given
        FlightService flightService = new FlightService();
        flightService.addFlight(new Flight("Gdańsk", "Wrocław"));
        flightService.addFlight(new Flight("Gdańsk", "Kraków"));
        flightService.addFlight(new Flight("Warszawa", "Wrocław"));

        // When
        List<Flight> flightsFromGdansk = flightService.findFlightsFrom("Gdańsk");

        // Then
        assertEquals(2, flightsFromGdansk.size());
    }

    @Test
    void testFindFlightsTo() {
        // Given
        FlightService flightService = new FlightService();
        flightService.addFlight(new Flight("Gdańsk", "Wrocław"));
        flightService.addFlight(new Flight("Kraków", "Wrocław"));
        flightService.addFlight(new Flight("Warszawa", "Kraków"));

        // When
        List<Flight> flightsToWroclaw = flightService.findFlightsTo("Wrocław");

        // Then
        assertEquals(2, flightsToWroclaw.size());
    }

    @Test
    void testFindFlightsThrough() {
        // Given
        FlightService flightService = new FlightService();
        flightService.addFlight(new Flight("Gdańsk", "Kraków"));
        flightService.addFlight(new Flight("Kraków", "Wrocław"));
        flightService.addFlight(new Flight("Warszawa", "Wrocław"));

        // When
        List<Flight> flightsThroughKrakow = flightService.findFlightsThrough("Gdańsk", "Kraków", "Wrocław");

        // Then
        assertEquals(1, flightsThroughKrakow.size());
    }
}
