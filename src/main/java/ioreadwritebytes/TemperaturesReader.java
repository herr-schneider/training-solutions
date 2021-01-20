package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path file = Path.of(pathString);
        byte[] temperatures;
        try {
            temperatures = Files.readAllBytes(file);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return new Temperatures(temperatures);
    }
}
