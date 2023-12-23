package com.example.geektrust.GmanPower;

import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;

public class GmanCoordinatePowerCalculation extends GmanPowerCalculation {
    public GmanCoordinatePowerCalculation(Source source, Destination destination) {
        super(source, destination);
    }

    @Override
    public long calculatePower() {
        long deltaXY = Math.abs(source.getyCoordinate() - destination.getyCoordinate()) + Math.abs(source.getxCoordinate() - destination.getxCoordinate());
        long powerReducedInCoordinatesChange = 10;
        long poweUsedInCoodinates = deltaXY * powerReducedInCoordinatesChange;

        return poweUsedInCoodinates;
    }
}
