package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    List<String> Ids = new ArrayList<>();

    public List<String> getIds() {
        return new ArrayList<>(Ids);
    }

    public void readIdsFromFile(String filename) {
        filename = "/" + filename;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(IdManager.class.getResourceAsStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Ids.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found");
        }
    }
}

