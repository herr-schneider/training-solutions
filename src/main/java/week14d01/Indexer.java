package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String str : names) {
            if (!result.containsKey(str.charAt(0))) {
                List<String> temp = Arrays.asList(str);
                result.put(str.charAt(0), temp); // new Arraylist
            } else {
                List<String> temp = new ArrayList<>(result.get(str.charAt(0)));
                temp.add(str);
                result.replace(str.charAt(0), temp);
            }
        }
        return result;
    }

    public Map<Character, Set<String>> indexer(List<String> names) {
        Map<Character, Set<String>> result = new HashMap<>();
        for (String str : names) {
            char initial = str.charAt(0);
            if (!result.containsKey(initial)) {
                result.put(initial, new HashSet<>());
            }
            result.get(initial).add(str);
        }

        return result;
    }

    public Map<Character, List<String>> indexerList(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String str : names) {
            char initial = str.charAt(0);
            if (!result.containsKey(initial)) {
                result.put(initial, new ArrayList<>());
            }
            result.get(initial).add(str);
        }

        return result;
    }

    public static void main(String[] args) {
        Indexer indexer = new Indexer();
        System.out.println(indexer.index(Arrays.asList("Odon", "Lujza", "Lajos", "Abraham", "Magdolna")));
        System.out.println(indexer.indexer(Arrays.asList("Odon", "Lujza", "Lajos", "Abraham", "Magdolna")));
        System.out.println(indexer.indexerList(Arrays.asList("Odon", "Lujza", "Lajos", "Abraham", "Magdolna")));
    }
}
