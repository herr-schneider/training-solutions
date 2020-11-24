package week05d02;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ChangeLetter {
    private final char[] inputChars = {'a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'};

    public String ChangeVowels(String inputText) {

        for (char c : inputChars) {
             inputText = inputText.replace(c, '*');
        }
        return inputText;
}
    @Test
    public void ChangeVowelsTest() {
        ChangeLetter c = new ChangeLetter();
        assertEquals("V*l*m*", c.ChangeVowels("Valami"));
    }
}


