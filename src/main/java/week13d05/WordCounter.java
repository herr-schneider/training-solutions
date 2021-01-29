package week13d05;

//        Írj egy metódust, amely megszámolja, hogy hány különböző betű van
//        egy szóban. A kis és nagybetűk közötti különbség nem számít!
//        A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
//        angol ábécé betűit!

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordCounter {

    public int counter(String word) {
        Set<Character> sc = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase().charAt(i);
            // System.out.print((int) c);
            if ((c != 32 && c < 48) || c > 58) {
                sc.add(c);
                // System.out.print("*");
            }
            // System.out.print(", ");
        }
        return sc.size();
    }

    public int easyCounter(String word) {
        int result = 0;
        Set<Character> sc = new HashSet<>();
        char[] chars = word.toLowerCase().toCharArray();
        for (char c = 'a'; c <= 'z'; c++) { //ASCII 97-120
            for (char charOfstr : chars)
            if (charOfstr == c) {
                result++;
                break;
            }
        }
        return result;
    }

    public int counterInt(String word) {
        int result = 0;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.toLowerCase().charAt(i);
            if ((c != 32 && c < 48) || c > 58) {
                result++;
            }
        }
        return result;
    }

    public Map<Character, Integer> counterToMap(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase().charAt(i);
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            } else {
                result.put(c, 1);
            }
        }
        return result;
    }
}
