package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Hachiko {
    final Charset latin1 = Charset.forName("ISO-8859-1");
    final Charset latin2 = Charset.forName("ISO-8859-2");
    final Charset utf8 = StandardCharsets.UTF_8;

    public Map<String, Integer> countWords(String fileName, String word, String... words) {
        Path file = Path.of(fileName);
        if (fileName == null || word == null){
            throw new IllegalArgumentException("Nem lehet üres parameter!");
        }
        Map<String, Integer> results = new HashMap<>();
        results.put(word, 0);
        for (String wordFromArray : words) {
            results.put(wordFromArray, 0);
        }
        String[] keys = results.keySet().toArray(String[]::new);
        try (BufferedReader bf = Files.newBufferedReader(file, utf8)) {
            String line;
            while ((line = bf.readLine()) != null) {
                for (String str : keys) {
                    if (line.contains(str)) {
                        results.replace(str, results.get(str) + 1);
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
        return results;
    }
}