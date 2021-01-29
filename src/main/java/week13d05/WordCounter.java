package week13d05;

//        Írj egy metódust, amely megszámolja, hogy hány különböző betű van
//        egy szóban. A kis és nagybetűk közötti különbség nem számít!
//        A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
//        angol ábécé betűit!

import java.util.*;
//import java.util.stream.Collectors;

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
        char[] chars = word.toLowerCase().toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (char charOfstr : chars) {
                if (charOfstr == c) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public int easyCounter2(String word) { // ige legyen a metodus név
        Set<Character> sc = new HashSet<>();
        char[] chars = word.toLowerCase().toCharArray();
        for (char charOfstr : chars)
            if (charOfstr >= 'a' && charOfstr <= 'z') {
                sc.add(charOfstr);
            }
        return sc.size();
    }
    // halmaz retainALL megnézni halmaz metszet készítés

    public int easyCounterBySet2(String word) {
        Set<Character> sc = new HashSet<>();
        char[] chars = word.toLowerCase().toCharArray();
        for (int i=0; i<chars.length; i++){
            sc.add(chars[i]);
        }
       Character[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Set<Character> abc = new HashSet<>(Arrays.asList(charArray));
        // Set<Character> abc = Arrays.stream(charArray).collect(Collectors.toSet());
        abc.retainAll(sc);
        return abc.size();
    }

    public int easyCounterBySet(String word) {
        Set<Character> sc = new HashSet<>();
        char[] chars = word.toLowerCase().toCharArray();
        for (int i=0; i<chars.length; i++){
            sc.add(chars[i]);
        }
        Set<Character> abc = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            abc.add(c);
        }
        abc.retainAll(sc);
        return abc.size();
    }

    public int counterInt(String word) {
        int result = 0;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.toLowerCase().charAt(i); // nem jó, ugyanazt többször is megszámolja
            if (c < 120 && c > 97) {
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

    public Map<Character, Integer> counterToMapEnlish(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase().charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (result.containsKey(c)) {
                    result.put(c, result.get(c) + 1);
                } else {
                    result.put(c, 1);
                }
            }
        }
        return result;
    }
}
