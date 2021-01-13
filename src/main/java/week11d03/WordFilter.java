package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> results = new ArrayList<>();
        for (String word : words) {
            for (char ch : word.toLowerCase().toCharArray()) {
                if (ch == c) {
                    results.add(word);
                    break;
                }
            }
        }
        return new ArrayList<>(results);
    }

    public List<String> wordsWithChar2(List<String> words, char c) {
        List<String> results = new ArrayList<>();
        for (String word : words) {
               if (word.toLowerCase().contains(String.valueOf(c))){
                   results.add(word);
                }
            }
        return new ArrayList<>(results);
    }

    public List<String> wordsWithChar3(List<String> words, char c) {
        List<String> results = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().indexOf(c) >= 0){
                results.add(word);
            }
        }
        return new ArrayList<>(results);
    }
}
