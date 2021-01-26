package week13d02;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    Airport ar = new Airport();
    @Test
    void readFromFile() {
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        assertEquals(100, ar.getFlies().size());
    }

    @Test
    void readFromFile2() {
    ar.readFromFile2("src/main/java/week13d02/cities.txt");
        assertEquals(100, ar.getFlies().size());
       assertEquals("FG3210", ar.earliestDeparture().getName());
       assertEquals("Departure", ar.earliestDeparture().getType());
       assertEquals("Zurich", ar.earliestDeparture().getTarget());
       assertEquals(LocalTime.of(6,16), ar.earliestDeparture().getTime());
    }

    @Test
    void localTimeTest() {
        ar.readFromFile2("src/main/java/week13d02/cities.txt");
        int serial = 1;
        for (Fly fly : ar.getFlies()){
            System.out.println(serial + ": " + fly.getTime());
            serial++;
        }
    }

    @Test
    void typeFinder() {
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        assertEquals("Departure",ar.typeFinder());
    }

    @Test
    void flyFinder() {
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        assertEquals("Departure", ar.flyFinder("JP2694").getType());
        assertEquals("Oslo", ar.flyFinder("JP2694").getTarget());
        assertEquals(7, ar.flyFinder("JP2694").getHour());
        assertEquals(57, ar.flyFinder("JP2694").getMinute());
    }

    @Test
    void flyFinderByCityAndType() {
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        List<Fly> flyList = ar.flyFinderByCityAndType("Dublin", "Arrival");
        assertEquals(3, ar.flyFinderByCityAndType("Dublin", "Arrival").size());
        assertEquals(3, flyList.size());
    }

    @Test
    void earlierFly() {
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        assertEquals("Zurich", ar.earlierFly().getTarget());
        assertEquals(6, ar.earlierFly().getHour());
        assertEquals(16, ar.earlierFly().getMinute());
    }
}