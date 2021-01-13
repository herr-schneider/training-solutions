package week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addRide() {
        Courier c = new Courier();
       c.addRide(new Ride(1,1,20));
       c.addRide(new Ride(2,3,12));
      // c.addRide(new Ride(2,2,12));

    }

    @Test
    void getRides() {
    }
}