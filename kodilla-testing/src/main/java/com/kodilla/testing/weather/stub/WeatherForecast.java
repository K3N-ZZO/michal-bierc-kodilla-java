package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String,Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double avgTemperature(){
        Map<String,Double> temperatures1 = temperatures.getTemperatures();
        double sumTemperatures = 0.0;
        for (Map.Entry<String, Double> temperature : temperatures1.entrySet()) {
            sumTemperatures += temperature.getValue();
        }
        return sumTemperatures / temperatures1.size();
    }
    public double medianTemperature(){
        List<Double> temp = temperatures.getTemperatures().values().stream().sorted().toList();
        return temp.get(temp.size()/2);
    }

}
