package week10d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingTest {

    @Test
    public void testHiking(){
        Hiking h = new Hiking(10.0, 20.0, 15.0, 18.0);
        assertEquals(13, h.getPlusElevation());
    }
}
