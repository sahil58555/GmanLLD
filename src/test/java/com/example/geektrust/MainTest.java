package com.example.geektrust;

import com.example.geektrust.Coordinates.Destination;
import com.example.geektrust.Coordinates.Source;
import com.example.geektrust.Direction.Cardinal;
import com.example.geektrust.GmanPower.GmanCoordinatePowerCalculation;
import com.example.geektrust.GmanPower.GmanTurnPowerCalculation;
import com.example.geektrust.InputOutputUtil.FileInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {

    private Source source;
    private Destination destination;
    @BeforeAll
    void setup() {
        source = new Source(3, 6, 'N');
        destination = new Destination(1, 0);
    }

    @Test
    void testGmanCoordinatePowerCalculation() {
        GmanCoordinatePowerCalculation gmanCoordinatePowerCalculation = new GmanCoordinatePowerCalculation(source, destination);
        long result = gmanCoordinatePowerCalculation.calculatePower();

        assertEquals(80, result, "Coordinate power should be 50");
    }

    @Test
    void testGmanTurnPowerCalculation() {
        GmanTurnPowerCalculation gmanTurnPowerCalculation = new GmanTurnPowerCalculation(source, destination);
        long result = gmanTurnPowerCalculation.calculatePower();

        assertEquals(10, result, "Turn power should be 10");
    }

    @Test
    void testFindTotalTurnsOfGman() {
        GmanTurnPowerCalculation gmanTurnPowerCalculation = new GmanTurnPowerCalculation(source, destination);
        long result = gmanTurnPowerCalculation.findTotalTurns();

        assertEquals(2, result, "Total turns should be 2");
    }

    @Test
    void testGmanShouldNotMove() {
        Cardinal cardinal = new Cardinal(source, destination);
        boolean result = cardinal.hasMove();

        assertFalse(result);
    }

    @Test
    void testGmanShouldMove() {
        Cardinal cardinal = new Cardinal(new Source(3, 6, 'S'), destination);
        boolean result = cardinal.hasMove();

        assertTrue(result);
    }

    @Test
    void testGmanShouldReach() {
        Cardinal cardinal = new Cardinal(new Source(1, 0, 'N'), destination);
        boolean result = cardinal.hasGmanReach();

        assertTrue(result);
    }

    @Test
    void testGmanShouldNotReach() {
        Cardinal cardinal = new Cardinal(source, destination);
        boolean result = cardinal.hasGmanReach();

        assertFalse(result);
    }

    // Create a ByteArrayOutputStream to capture the console output
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Save the original System.out before each test
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Reset System.out after each test
    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testWriteToConsole() {
        // Arrange
        Gman gman = new Gman(source, destination);
        String testData = "POWER 110";

        // Act
        gman.printRemainingPower();

        // Assert
        String expectedOutput = testData + System.lineSeparator(); // System.lineSeparator() is the newline character
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testGetInputDataFromFile_FileNotFound() {
        // Arrange
        FileInput fileInput = new FileInput();
        String nonExistentFilePath = "non_existent_file.txt";

        // Act and Assert
        assertThrows(Exception.class, () -> {
            fileInput.getInputDataFromFile(nonExistentFilePath);
        }, "File Not Found");
    }
}