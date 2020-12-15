package week08d02;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    @Test
    public void numbersTest(){
        List<Integer> numbers;
        Lottery l = new Lottery();
        numbers = Arrays.asList(73, 89, 54, 72, 19);
        assertEquals(numbers,l.get5Numbers(5));
        numbers = Arrays.asList(18,38,45,15,22,36);
        assertEquals(numbers,l.getNumbers(6, 45, 5));
    }
    @Test
    public void sortingTest(){
        Lottery l = new Lottery();
        List<Integer> numbers = Arrays.asList(15,18,22,36,38,45);
        assertEquals(numbers,l.getSortNumbers(l.getNumbers(6, 45, 5)));
    }

}
