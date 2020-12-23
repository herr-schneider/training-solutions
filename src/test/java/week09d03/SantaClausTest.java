package week09d03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SantaClausTest {


    @Test
    public void testRandom() {
        List<Person> persons = Arrays.asList(new Person("s", 12),
                new Person("a", 14),
                new Person("n", 16),
                new Person("t", 18),
                new Person("a", 20));

        SantaClaus santa = new SantaClaus(persons);
        santa.getThroughChimneys();
        for (Person person : persons) {
            System.out.println(person.getPresent());
        }
    }

    @Test
    public void testRandomSeed() {
        List<Person> persons = Arrays.asList(new Person("s", 12, new Random(5)),
                new Person("a", 14, new Random(5)),
                new Person("n", 16, new Random(5)),
                new Person("t", 18, new Random(5)),
                new Person("a", 20, new Random(5)));

        SantaClaus santa = new SantaClaus(persons);
        santa.getThroughChimneys();
        assertEquals(Present.ELECTRONIC, persons.get(0).getPresent());
        assertEquals("HOUSEKEEPING", persons.get(1).getPresent().toString());
        assertEquals("HOUSEKEEPING", persons.get(2).getPresent().toString());
        assertEquals(Present.HOUSEKEEPING, persons.get(3).getPresent());
    }
}
