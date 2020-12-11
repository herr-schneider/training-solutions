package week07d03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

    @Test
    public void testInc(){
        List<Integer> testList = Arrays.asList(new Integer[]{1,2,3,4,5});
        NumberList n = new NumberList();
        assertTrue(n.isIncreasing(testList));
    }

    @Test
    public void testDec(){
        List<Integer> testList = Arrays.asList(new Integer[]{5,4,3,2,1});
        NumberList n = new NumberList();
        assertFalse(n.isIncreasing(testList));
    }

    @Test
    public void testSame(){
        List<Integer> testList = Arrays.asList(new Integer[]{1,2,3,3,3});
        NumberList n = new NumberList();
        assertTrue(n.isIncreasing(testList));
    }
}
