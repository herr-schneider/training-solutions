package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CovidStat {
    final Charset latin1 = Charset.forName("ISO-8859-1");
    final Charset latin2 = Charset.forName("ISO-8859-2");
    final Charset utf8 = StandardCharsets.UTF_8;
    final Charset win = Charset.forName("Windows-1250");

    final int topCases = 3;

    public List<CountryStat> readFile() {
        Path file = Path.of("data.csv");
        List<CountryStat> cases = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(file, utf8)) {
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.contains("Hungary")) {
                    cases.add(processLine(line));
                }
            }
        } catch (
                IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
        return cases;
    }

    private CountryStat processLine(String line) {
        String[] temp = line.split(",");
        int cases = Integer.parseInt(temp[2]);
        return new CountryStat(temp[1], cases);
    }

    private List<CountryStat> sorter(List<CountryStat> cases) {
        List<CountryStat> copyOfCases = new ArrayList<>(cases);
        Collections.sort(copyOfCases);
        return copyOfCases;
    }

    private void printer(List<CountryStat> sorted){
        for (int i=0; i<3; i++){
            System.out.println(sorted.get(i));
        }
    }
}