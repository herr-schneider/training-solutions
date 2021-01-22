package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Korona {
    final Path path = Path.of("src/main/java/week12d05/index.html");


    public int reader() { // mem igény nagy, nem jó
        int count = 0;
        try {
            List<String> reader = Files.readAllLines(path);
            for (String str : reader)
                if (str.toLowerCase().contains("koronavírus")) {
                    count++;
                }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return count;
    }

    public int lineReader() {
        int count = 0;
        try (
                BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("koronavírus")) {
                    count++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return count;
    }
}
