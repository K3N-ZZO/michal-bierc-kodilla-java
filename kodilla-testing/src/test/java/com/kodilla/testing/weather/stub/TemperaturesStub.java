package com.kodilla.testing.weather.stub;

import java.util.*;

public class TemperaturesStub implements Temperatures{

    @Override
    public Map<String,Double> getTemperatures() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Kiev", 25.0);
        temperaturesMap.put("London", 15.0);
        temperaturesMap.put("Paris", 20.0);
        temperaturesMap.put("Rome", 22.0);
        temperaturesMap.put("New York", 18.0);
        return temperaturesMap;
    }
}
