package week05d02;


import java.util.Arrays;
import java.util.List;

public class ChangeLetter {
    public String ChangeVowels(String inputText) {
        char[] inputChars = {'a', 'e', 'o', 'u', 'i'};
        for (char c : inputChars) {
             inputText = inputText.replace(c, '*');
        }
        return inputText;
}

    public static void main(String[] args) {
        ChangeLetter c = new ChangeLetter();
        System.out.println(c.ChangeVowels("Valami"));
    }
}


