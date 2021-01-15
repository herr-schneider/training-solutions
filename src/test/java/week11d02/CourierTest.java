package week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addRide() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(2, 3, 12));
        // c.addRide(new Ride(2,2,12));
    }

    @Test
    void addRide2() {
        Courier c = new Courier();
        c.addRide2(new Ride(1, 1, 20));
        c.addRide2(new Ride(2, 3, 12));
        // c.addRide(new Ride(2,2,12));
    }

    @Test
    void addRide3() {
        Courier c = new Courier();
        c.addRide3(new Ride(1, 1, 20));
        c.addRide3(new Ride(2, 3, 12));
    }

    @Test
    void addRide3andFreeDay() {
        Courier c = new Courier();
        c.addRide3(new Ride(1, 1, 20));
        c.addRide3(new Ride(2, 1, 12));
        c.addRide3(new Ride(2, 2, 12));
        c.addRide3(new Ride(3, 1, 20));
        c.addRide3(new Ride(4, 2, 12));
        c.addRide3(new Ride(4, 3, 12));
        System.out.println(c.getRides().size());
        System.out.println(c.firstFreeDay());
        // System.out.println(c.freeDay());
    }
}