package ioreadwritebytes;


import java.util.Arrays;

public class Temperatures {
    private byte[] temperatures;

    public Temperatures(byte[] temperatures) {
        this.temperatures = temperatures;
    }

    public double getYearAverage() {
        double sum = 0.0;
        double items = 0.0;
        for (byte temperature : temperatures) {
            sum += temperature;
            items++;
        }
        return sum / items;
    }

    public double getMonthAverage() {
        double sum = 0.0;
        double items = 0.0;
        for (int i = 335; i < 365; i++) {
            sum += temperatures[i];
            items++;
        }
        return sum / items;
    }

    public byte[] getData() {
        return temperatures;
    }
}
