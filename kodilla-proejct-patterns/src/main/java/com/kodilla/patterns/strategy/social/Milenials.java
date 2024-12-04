package com.kodilla.patterns.strategy.social;

public class Milenials extends User {
    public Milenials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
