package com.example.geektrust.Direction;

import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;

public class Cardinal {
    private int sourceX;
    private int sourceY;
    private int destinationX;
    private int destinationY;
    private final String directions = "NESW";
    private int pointerToDirections;

    public Cardinal(Source source, Destination destination) {
        sourceX = source.getxCoordinate();
        sourceY = source.getyCoordinate();
        destinationX = destination.getxCoordinate();
        destinationY = destination.getyCoordinate();
        pointerToDirections = directions.indexOf(source.getDirection());
    }

    public boolean hasMove() {
        int oldSourceX = sourceX;
        int oldSourceY = sourceY;
        char currentDirection = directions.charAt(pointerToDirections);

        switch (currentDirection) {
            case 'E':
                sourceX = Math.max(sourceX, destinationX);
                break;
            case 'W':
                sourceX = Math.min(sourceX, destinationX);
                break;
            case 'N':
                sourceY = Math.max(sourceY, destinationY);
                break;
            case 'S':
                sourceY = Math.min(sourceY, destinationY);
                break;
        }

        pointerToDirections = (pointerToDirections + 1) % directions.length();

        boolean hasCoordinatesChanged = !((oldSourceX == sourceX) && (oldSourceY == sourceY));
        return hasCoordinatesChanged;
    }

    public boolean hasGmanReach() {
        boolean hasReach = (sourceX == destinationX) && (sourceY == destinationY);
        return hasReach;
    }
}
