package com.example.geektrust.Coordinates;

public class Destination {
    private final int xCoordinate;
    private final int yCoordinate;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
    public Destination(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
