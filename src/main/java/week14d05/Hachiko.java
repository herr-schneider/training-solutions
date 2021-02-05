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
    final Charset win = Charset.forName("Windows-1250");

    public Map<String, Integer> countWords(String fileName, String word, String... words) {
        if (fileName == null || word == null || words.length < 1) {
            throw new IllegalArgumentException("Nem lehet üres parameter!");
        }
        Path file = Path.of(fileName);
        Map<String, Integer> results = new HashMap<>(); // List<String> findWord = new ArrayList<>();
        results.put(word, 0); // findWord.add(word);
        for (String wordFromArray : words) {
            results.put(wordFromArray, 0); // findWord.add(wordFromArray);
        }
        String[] keys = results.keySet().toArray(String[]::new);
        try (BufferedReader bf = Files.newBufferedReader(file, utf8)) {
            String line;
            while ((line = bf.readLine()) != null) { //for (String str : findWord){ ez csak azert, ne kelljen keyset().toArray}
                for (String str : keys) { //
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


    public Map<String, Integer> wordCounter(BufferedReader br, String... words) {
        Map<String, Integer> result;
        try {
            result = processLine(br, words);
        } catch (IOException e) {
            throw new IllegalArgumentException("Exception when reading file!", e);
        }
        return result;
    }
    private void modifyMap(Map<String, Integer> result, String line, String word) {
        if (line.toLowerCase().contains(word.toLowerCase())) {
            int count = result.get(word);
            result.put(word, count + 1);
        }
    }

    private Map<String, Integer> processLine(BufferedReader br, String[] words) throws IOException {
        Map<String, Integer> result = loadMap(words);
        String line;
        while ((line = br.readLine()) != null) {
            for (String word : words) {
                modifyMap(result, line, word);
            }
        }
        return result;
    }

    private Map<String, Integer> loadMap(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            result.put(word, 0);
        }
        return result;
    }
    /*
        public Map<String, Integer> wordCounter(String fileName, String encoding, String... words) {
            Map<String, Integer> result = new HashMap<>();
            try (BufferedReader br = Files.newBufferedReader(Path.of(fileName), Charset.forName(encoding))) {
                String line;
                while ((line = br.readLine()) != null) {
                    for (String word : words) {
                        if (line.contains(word)) {
                            if (!result.containsKey(word)) {
                                result.put(word, 0);
                            }
                            result.replace(word, result.get(word) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    */
    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("hachiko.srt"), Charset.forName("windows-1250"))) {
            Hachiko hachiko = new Hachiko();
            System.out.println(hachiko.wordCounter(br, "Hachiko", "pályaudvar", "jó", "haza"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Exception when loading file", e);
        }
    }
}
