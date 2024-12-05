package com.kodilla.good.patterns.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> findFlightsFrom(String city) {
        return flights.stream()
                .filter(flight -> flight.getDeparture().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(String city) {
        return flights.stream()
                .filter(flight -> flight.getArrival().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsThrough(String departure, String layover, String arrival) {
        List<Flight> firstLeg = findFlightsFrom(departure).stream()
                .filter(flight -> flight.getArrival().equals(layover))
                .collect(Collectors.toList());

        List<Flight> secondLeg = findFlightsFrom(layover).stream()
                .filter(flight -> flight.getArrival().equals(arrival))
                .collect(Collectors.toList());

        List<Flight> throughFlights = new ArrayList<>();
        for (Flight f1 : firstLeg) {
            for (Flight f2 : secondLeg) {
                throughFlights.add(new Flight(departure, arrival));
            }
        }

        return throughFlights;
    }
}
