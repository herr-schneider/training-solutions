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
        int lineNumber = 0;
        String longestCityName = "Unknown error!";
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            headerSkipper(bf); //olvashatosag kedveert
            String[] lineSplit;
            while ((line = bf.readLine()) != null) {
                lineNumber++;
                String city = splitLine(line, lineNumber);
                if (maxLenght < city.length()) {
                    longestCityName = city;
                    maxLenght = city.length();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
        return longestCityName;
    }

    private void headerSkipper(BufferedReader br) throws IOException {
        br.readLine();
    }

    private String splitLine(String line, int lineNumber) throws IOException {
        String[] temp = line.split(";");
        if (temp.length < 1) {
            throw new IOException("Wrong line" + lineNumber);
        }
        return temp[1].trim();
    }
}
