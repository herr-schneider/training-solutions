package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    public void counter() {
        WordCounter wc = new WordCounter();
        assertEquals(10,wc.counter("alma egy gyümölcs 120"));
    }

    @Test
    public void easyCounter() {
        WordCounter wc = new WordCounter();
        assertEquals(8,wc.easyCounter2("alma egy gyümölcs 120"));
    }

    @Test
    public void counterByRetainAll() {
        WordCounter wc = new WordCounter();
        assertEquals(8,wc.easyCounterBySet("alma egy gyümölcs 120"));
    }

    @Test
    public void counterByRetainAll2() {
        WordCounter wc = new WordCounter();
        assertEquals(8,wc.easyCounterBySet2("alma egy gyümölcs 120"));
    }

    @Test
    public void counterToMap() {
        WordCounter wc = new WordCounter();
        System.out.println(wc.counterToMap("alma egy gyümölcs 120"));
        System.out.println(wc.counterToMapEnlish("alma egy gyümölcs 120"));
    }
}