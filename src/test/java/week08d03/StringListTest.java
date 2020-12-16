package week08d03;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListTest {
    List str1 = Arrays.asList("egy", "ketto", "harom", "negy");
    List str2 = Arrays.asList("negy", "ot", "hat", "het");
    StringList s = new StringList();

    @Test
    public void numbersTest() {

        assertEquals(Arrays.asList("egy", "ketto", "harom", "negy", "ot", "hat", "het"), s.stringLists(str1, str2));
        }

    @Test
    public void numbersTestNoCase() {

        assertEquals(Arrays.asList("egy", "ketto", "harom", "negy", "ot", "hat", "het"), s.stringListsNoCase(str1, str2));
    }
}
