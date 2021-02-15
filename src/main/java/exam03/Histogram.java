package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader) {
        StringBuilder results = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                int n = Integer.parseInt(line);
                for (int i = 0; i < n; i++) {
                   results.append("*");
                }
                results.append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
        return results.toString();
    }
}

