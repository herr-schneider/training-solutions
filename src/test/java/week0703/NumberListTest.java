package week0703;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

    @Test
    public void testInc(){
        List<Integer> testList = Arrays.asList(new Integer[]{1,2,3,4,5});
        NumberList n = new NumberList();
        assertTrue(n.isIncreasing(testList));
    }
}
