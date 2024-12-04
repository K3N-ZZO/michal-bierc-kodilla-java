package com.kodilla.patterns.strategy.social;

import java.util.concurrent.Flow;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Twitter publisher] Publishing post on Twitter";
    }
}
