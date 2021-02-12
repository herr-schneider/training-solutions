package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class BattleStat {
    private final Charset latin1 = Charset.forName("ISO-8859-1");
    private final Charset latin2 = Charset.forName("ISO-8859-2");
    private final Charset utf8 = StandardCharsets.UTF_8;
    private final Charset win = Charset.forName("Windows-1250");

    private final int topCases = 3;

    public Map<String, Integer> readFile() {
        Path file = Path.of("src/main/java/week15d05/battles.csv");
        Map<String, Integer> cases = new TreeMap<>();
        try (BufferedReader bf = Files.newBufferedReader(file, utf8)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] temp = line.split(",");
                for (int i = 5; i < 13; i++) {
                    if (!cases.containsKey(temp[i])) {
                        cases.put(temp[i], 1);
                    } else {
                        cases.put(temp[i], cases.get(temp[i]) + 1);
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
        return cases;
    }

    public static void main(String[] args) {
        BattleStat bt = new BattleStat();
        bt.readFile();
    }
}
