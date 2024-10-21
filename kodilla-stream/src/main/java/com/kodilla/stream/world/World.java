package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class World {
    private final List<Continent> continents = new ArrayList<>();

    public void addContinent(final Continent continent) {
        continents.add(continent);
    }
    public List<Continent> getContinents() {
        return continents;
    }
    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
