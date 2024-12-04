package com.kodilla.patterns.strategy;

public final class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive Predictor] buy stock for XYZ";
    }
}
