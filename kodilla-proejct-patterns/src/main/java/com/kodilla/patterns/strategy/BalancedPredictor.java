package com.kodilla.patterns.strategy;

public final class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] buy shared units of XYZ";
    }
}
