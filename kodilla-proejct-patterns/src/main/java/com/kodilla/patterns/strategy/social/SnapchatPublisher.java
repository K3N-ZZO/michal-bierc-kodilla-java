package com.kodilla.patterns.strategy.social;

import java.util.concurrent.Flow;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Snapchat Publisher] Publishing post on Snapchat";
    }
}
