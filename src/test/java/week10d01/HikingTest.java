package week10d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HikingTest {

    @Test
    public void testHiking() {
        Hiking h = new Hiking(10.0, 20.0, 15.0, 18.0);
        assertEquals(13, h.getPlusElevation());
    }

    @Test
    public void testHikingList() {

        assertEquals(13, new Hiking(Arrays.asList(10.0, 20.0, 15.0, 18.0)).getPlusElevation());
    }

    @Test
    public void testHikingNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hiking(new ArrayList<>()).getPlusElevation());
        Assertions.assertEquals("Nem jó!", ex.getMessage());
    }
}
