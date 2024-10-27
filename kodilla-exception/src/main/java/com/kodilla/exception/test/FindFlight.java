package com.kodilla.exception.test;

import java.util.HashMap;

public class FindFlight {
    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        HashMap<String,Boolean> map = new HashMap<>();
        map.put("Warsaw",true);
        map.put("Berlin",false);
        map.put("Paris",true);

        if(!map.containsKey(flight.getArrivalAirport())){
            throw new RouteNotFoundException("Airport not found: " +flight.getArrivalAirport());
        }
        return map.get(flight.getArrivalAirport());
    }
}
