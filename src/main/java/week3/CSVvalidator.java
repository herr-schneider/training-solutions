package week3;

import java.util.ArrayList;
import java.util.List;

public class CSVvalidator {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {continue;}
            else if (parts[0].length() < 7) {continue;}
            else {
                int year = Integer.parseInt(parts[1]);
                if (year < 1970 || year > 2020) {continue;}
            }
            validLines.add(line);
        }
        return validLines;
    }
}
