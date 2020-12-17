package week08d04;

import org.junit.Test;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExamplesStoreTest {

    @Test
    public void testOutput() {
        ExamplesStore e = new ExamplesStore();
        assertEquals("[1 Első feladat, 2 Második feladat]", e.sorter(e.getTitlesOfExamples()).toString());
    }
}
