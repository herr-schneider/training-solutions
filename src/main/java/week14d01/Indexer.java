package week14d01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String str : names) {
            if (!result.containsKey(str.charAt(0))){
            List<String> temp = Arrays.asList(str);
                result.put(str.charAt(0),temp);}
            if (result.containsKey(str.charAt(0))){
                List<String> temp = result.get(str.charAt(0));
                temp.add(str);
                result.put(str.charAt(0),temp);}
        }
        return result;
    }
}
