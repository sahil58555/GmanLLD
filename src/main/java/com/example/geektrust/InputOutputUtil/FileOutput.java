package com.example.geektrust.InputOutputUtil;

public class FileOutput {
    private final StringBuilder data;

    public FileOutput() {
        data = new StringBuilder();
    }

    public void write(String data) {
        this.data.append(data);
    }

    public void printToConsole() {
        System.out.println(data);
    }
}
