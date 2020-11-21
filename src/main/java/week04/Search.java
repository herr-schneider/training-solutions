package week04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Search s = new Search();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char c = scanner.nextLine().charAt(0);
        List<Integer> posOfChar = s.getIndexOfChar(str, c);
        for (int i = 0; i < posOfChar.size(); i++) {
            System.out.println(posOfChar.get(i));
        }
    }
}