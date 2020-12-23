package week09d03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SantaClausTest {

    @Test
    public void testEveryThing() {
        List<Person> persons = Arrays.asList(new Person("s", 12),
                new Person("a", 14),
                new Person("n", 16),
                new Person("t", 18),
                new Person("a", 20));

        SantaClaus santa = new SantaClaus(persons);
        santa.getThroughChimneys();
        for (Person person : persons){
        System.out.println(person.getPresent());
        }
    }
}
