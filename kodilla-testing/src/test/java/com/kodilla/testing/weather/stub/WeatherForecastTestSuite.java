package com.kodilla.testing.weather.stub;
import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    double sum;
    double result;

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;
    @BeforeEach
    public void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();                     // [14]
        temperaturesMap.put("Rzeszow", 25.5);                                      // [15]
        temperaturesMap.put("Krakow", 26.2);                                       // [16]
        temperaturesMap.put("Wroclaw", 24.8);                                      // [17]
        temperaturesMap.put("Warszawa", 25.2);                                     // [18]
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }
    @Test
    void testCalculateForecastWithStub() {
        //Given

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    public void testCalculateAvgTemperature() {
        //When
        double averagetemperature = weatherForecast.avgTemperature();
        //Then
        Assertions.assertEquals(25.56, averagetemperature);

    }
    @Test
    void testCalculateMedianTemperature() {

        //when
        double result = weatherForecast.medianTemperature();
        //Then
        Assertions.assertEquals(25.5, result);

    }

}
