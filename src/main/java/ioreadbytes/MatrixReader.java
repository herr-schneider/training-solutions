package ioreadbytes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }

    public void readBytesAndCreateMatrix(String fileName) {
        Path file = new File("src/main/java/ioreadbytes/" + fileName).toPath(); // Csak a moka kedveert
        try (InputStream is = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            while (is.read(buffer) > 0) {
                myMatrix.add(buffer);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!");
        }
    }

    public int numberOfColumnsWhereMoreZeros() { // Training360 megoldasa
        int numOfColumns = 0;
        for (int i = 0; i < 1000; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < myMatrix.size(); j++) {
                if (myMatrix.get(j)[i] == 48) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (zeros > ones) {
                numOfColumns++;
            }
        }
        return numOfColumns;
    }
}
