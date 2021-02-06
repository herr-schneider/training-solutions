package collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> result = new TreeSet<>();
        for (String str : randomStrings) {
            result.add(str);
        }
        return result;
    }
}
