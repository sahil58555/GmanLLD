package com.example.geektrust.GmanPower;

import com.example.geektrust.Direction.Cardinal;
import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;

public class GmanTurnPowerCalculation extends GmanPowerCalculation {
    public GmanTurnPowerCalculation(Source source, Destination destination) {
        super(source, destination);
    }
    public int findTotalTurns() {
        Cardinal cardinal = new Cardinal(source, destination);
        cardinal.hasMove();

        if(cardinal.hasGmanReach()) {
            return 0;
        }

        cardinal.hasMove();

        return cardinal.hasMove() ? 2 : 0;
    }

    @Override
    public long calculatePower() {
        int totalTurns = findTotalTurns();
        long powerReducedInTurnChange = 5;
        long powerUsedInTurn = totalTurns * powerReducedInTurnChange;

        return powerUsedInTurn;
    }
}
