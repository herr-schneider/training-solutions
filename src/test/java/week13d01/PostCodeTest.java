package week13d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostCodeTest {

    @Test
    public void testLongestCityName() {
        PostCode pc = new PostCode();
        assertEquals("Jászfelsőszentgyörgy", pc.readFromFile());
    }
}