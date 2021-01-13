package week11d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    public void wordsWithChar() {
        List<String> words = Arrays.asList("cica", "macska", "kutya","tigris","C");
        assertEquals(3, new WordFilter().wordsWithChar(words, 'c').size());
    }
    @Test
    public void wordsWithChar2() {
        List<String> words = Arrays.asList("cica", "macska", "kutya","tigris","C");
        assertEquals(3, new WordFilter().wordsWithChar2(words, 'c').size());
    }
    @Test
    public void wordsWithChar3() {
        List<String> words = Arrays.asList("cica", "macska", "kutya","tigris","C");
        assertEquals(3, new WordFilter().wordsWithChar3(words, 'c').size());
    }
}