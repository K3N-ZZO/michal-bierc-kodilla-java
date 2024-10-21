package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class Continent {
    private final String name;
    private final List<Country> Countries = new ArrayList<>();
    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        Countries.add(country);
    }
    public List<Country> getCountries() {
        return Countries;
    }
}

