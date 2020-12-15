package week08d02;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    @Test
    public void numbersTest(){
        List<Integer> numbers = Arrays.asList(41,7,39,4,17,1);
        Lottery l = new Lottery();
        assertEquals(numbers,l.getNumbers(45, 6, 5));
    }
}
