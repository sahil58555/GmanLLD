package com.example.geektrust.GmanPower;

import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;

public abstract class GmanPowerCalculation {
    protected final Source source;
    protected final Destination destination;

    public GmanPowerCalculation(Source source, Destination destination) {
        this.source = source;
        this.destination = destination;
    }

    public abstract long calculatePower();
}
