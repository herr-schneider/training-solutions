package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

public class MaxTravelTest {

    @Test
    public void testBus(){
        MaxTravel mt = new MaxTravel();
        assertEquals(12, mt.getMaxIndex(Arrays.asList(12,12,0,3,4,4,12)));
    }

}