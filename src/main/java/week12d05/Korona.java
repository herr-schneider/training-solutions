package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
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

    public int lineReader(String filePath, String word) { // BufferedReader megcsinalni a filepath helyett
        Path file = Path.of(filePath);
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(file)) { // new BufferedReader(new InputStreamReader(korona.class.getResourceAsStream("/index.html");
            String line;                                              // junit testnél getResourceAsStream kell
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(word)) {
                    count++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("File not found", npe);
        }
        return count;
    }

    public void URLreader(String address) {
        try {
            URL url = new URL(address); // URLConnection koveti az atiranyitast, az URL nem
            InputStream content = url.openStream();
        } catch (MalformedURLException malformedURLException) {
            throw new IllegalStateException("Rossz az URL");
        } catch (IOException ioe) {
            throw new IllegalStateException("Hiba van!");
        }
    }

    //RandomAccessFile osztalynak utananezzni
}