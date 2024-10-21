package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity(){
        //Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country unitedKingdom = new Country("United Kingdom",new BigDecimal("69000000"));
        Country germany = new Country("Germany", new BigDecimal("40000000"));

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(unitedKingdom);

        World world = new World();
        world.addContinent(europe);

        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("147000000");
        assertEquals(expectedPeopleQuantity,totalPeopleQuantity);

    }
}
