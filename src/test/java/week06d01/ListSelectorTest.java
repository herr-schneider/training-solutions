package week06d01;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {
    ListSelector test = new ListSelector();


    @Test
    public void testList() {
        test.addToList("zero");
        test.addToList("one");
        test.addToList("two");
        test.addToList("three");
        test.addToList( "four");
        assertEquals("[two four]", test.selector());
    }

    @Test
    public void nullList() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> test.create(null));
        assertEquals("There is no element!", ex.getMessage());
    }

    @Test
    public void testListVararg() {
        test.create("zero", "one", "two", "three", "four");
        assertEquals("[two four]", test.selector());
    }

    @Test
    public void testZeroListVararg() {
        test.create("");
        assertEquals("", test.selector());
    }

    @Test
    public void testCommaVararg() {
        test.create("zero", "one", "two", "three", "four");
        assertEquals("[two, four]", test.convert(test.selector()));
    }
}

