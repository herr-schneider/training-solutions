package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String str : names) {
            if (!result.containsKey(str.charAt(0))){
            List<String> temp = Arrays.asList(str);
                result.put(str.charAt(0),temp);}
            if (result.containsKey(str.charAt(0))){
                List<String> temp = new ArrayList<>(result.get(str.charAt(0)));
                temp.add(str);
                result.replace(str.charAt(0),temp);}
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
    }
}
