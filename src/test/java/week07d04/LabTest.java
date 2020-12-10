package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabTest {

    @Test
    public void testLab() {
        Lab l = new Lab("Jeep");
        assertEquals("Jeep", l.getTitle());
        assertEquals(null, l.getCompletedAt());
        assertEquals(false, l.isCompleted());
        System.out.println(l.toString());
    }

    @Test
    public void testLabComplete() {
        Lab l = new Lab("Jeep");
        l.completed();
        assertEquals("Jeep", l.getTitle());
        assertEquals(LocalDate.now(), l.getCompletedAt());
        assertEquals(true, l.isCompleted());
        System.out.println(l.toString());
    }

}
