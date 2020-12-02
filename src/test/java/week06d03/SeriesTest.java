package week06d03;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {
    Series s = new Series();

    @Test
    public void testWordEraser(){
        Integer[] sourceInc = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] sourceDec = {8,7,6,5,4,3,2,1};
        Integer[] sourceRan = {5,4,7,9,5,2,8};
        assertEquals(SeriesType.INCREASING, s.calculateSeriesType(Arrays.asList(sourceInc)));
        assertEquals(SeriesType.DECREASING, s.calculateSeriesType(Arrays.asList(sourceDec)));
        assertEquals(SeriesType.RANDOM, s.calculateSeriesType(Arrays.asList(sourceRan)));
    }

    @Test
    public void nullListShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSeriesType(null));
        Assertions.assertEquals("Nem jó", ex.getMessage());
    }

    @Test
    public void emptyListShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSeriesType(Arrays.asList(1)));
        Assertions.assertEquals("Nem jó", ex.getMessage());
    }
}
