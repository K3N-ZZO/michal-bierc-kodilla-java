package com.kodilla.patterns.strategy;

public final class ConservativePredictor implements BuyPredictor{
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] buy debentures of XYZ";
    }
}
