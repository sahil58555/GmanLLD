package com.example.geektrust;

import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;
import com.example.geektrust.GmanPower.GmanCoordinatePowerCalculation;
import com.example.geektrust.GmanPower.GmanTurnPowerCalculation;
import com.example.geektrust.InputOutputUtil.FileInput;
import com.example.geektrust.InputOutputUtil.FileOutput;


public class Gman {
    private Source source;
    private Destination destination;

    public Gman(String filePath) throws Exception {
        init(filePath);
    }

    public Gman(Source source, Destination destination) {
        this.source = source;
        this.destination = destination;
    }

    private void init(String filePath) throws Exception {
        FileInput input = new FileInput();
        String inputData = input.getInputDataFromFile(filePath);
        findSourceAndDestination(inputData);
    }

    private void findSourceAndDestination(String inputData) {
        for(String data : inputData.split("\n")) {
            String[] nextLine = data.split(" ");

            if (nextLine[0].equals("PRINT_POWER")) {
                continue;
            }

            int xCoordinate = Integer.parseInt(nextLine[1]);
            int yCoordinate = Integer.parseInt(nextLine[2]);
            char direction = (nextLine.length == 3) ? '.' : nextLine[3].charAt(0);

            if(nextLine[0].equals("SOURCE")) {
                source = new Source(xCoordinate, yCoordinate, direction);
            }
            else if(nextLine[0].equals("DESTINATION")) {
                destination = new Destination(xCoordinate, yCoordinate);
            }
        }
    }

    public void printRemainingPower() {
        FileOutput output = new FileOutput();
        long currentPower = 200;
        long powerLeft = currentPower - powerUsedInShortesPath();

        output.write("POWER " + powerLeft);
        output.printToConsole();
    }

    private long powerUsedInShortesPath() {
        long powerUsedInCoordinate = new GmanCoordinatePowerCalculation(source, destination).calculatePower();
        long powerUsedInTurn = new GmanTurnPowerCalculation(source, destination).calculatePower();
        long powerUsed = powerUsedInCoordinate + powerUsedInTurn;

        return powerUsed;
    }
}
