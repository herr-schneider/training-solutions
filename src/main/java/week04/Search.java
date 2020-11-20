package week04;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        for (int z = 0; z < str.length(); z++) {
            if (str.charAt(z) == c) {
                result.add(z);
            }
        }
        return result;
    }
}