package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostCode {

//    A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza
//    a magyar városok listáját.
//    Add vissza a leghosszabb nevű várost!

    public String readFromFile() {
        Path file = Path.of("src/main/java/week13d01/iranyitoszamok-varosok-2021.csv");
        int maxLenght = 0;
        String longestCityName = "Unknown error!";
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            String[] lineSplit;
            while ((line = bf.readLine()) != null) {
                lineSplit = line.split(";");
                if (maxLenght < lineSplit[1].length()) { // hogy lehet kiszervezni
                    longestCityName = lineSplit[1];
                    maxLenght = lineSplit[1].length();
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found");
        }
        return longestCityName;
    }
}
