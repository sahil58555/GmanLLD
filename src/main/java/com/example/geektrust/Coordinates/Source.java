package com.example.geektrust.Coordinates;

public class Source {
    private final int xCoordinate;
    private final int yCoordinate;
    private final char direction;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public char getDirection() {
        return direction;
    }

    public Source(int xCoordinate, int yCoordinate, char direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }
}
