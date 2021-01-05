package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

public class MaxTravelTest {
    MaxTravel mt = new MaxTravel();

    @Test
    public void testBus(){
        assertEquals(12, mt.getMaxIndex(Arrays.asList(12,12,0,3,4,4,12)));
    }

    @Test
    public void testMethodOverload(){
        MaxTravel mt = new MaxTravel();
        assertEquals(4, mt.getMaxIndex(12,12,0,3,4,4,4));
    }
}