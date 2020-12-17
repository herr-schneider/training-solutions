package week08d04;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamplesStore {

    public List<String> getTitlesOfExamples() {
        List<String> results = new ArrayList<>();
        //try (Scanner scan = new Scanner(ExamplesStore.class.getResourceAsStream("examples.md"));) {
        try (Scanner scan = new Scanner(Path.of("./src/main/java/week08d04/examples.md"));) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.charAt(0) == '#') {
                    results.add(line);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Nincs meg a file");
        }
        return results;
    }

    public List<String> sorter(List<String> sortable) {
        List<String> results = new ArrayList<>();
        String tempStr;
        for (int i = 0; i < sortable.size(); i++) {
            tempStr = sortable.get(i);
            if (tempStr.charAt(0) == '#') {
                tempStr = tempStr.replace('#', (char) (i + '1'));
                results.add(tempStr);
            }
        }
        return results;
    }

}


