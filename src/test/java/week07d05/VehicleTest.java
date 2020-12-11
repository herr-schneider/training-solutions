package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void vehicleTest(){
        Vehicle v = new Vehicle();
        assertEquals(5, v.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, v.getTransmissionType());
    }

    @Test
    public void motorCycleTestSeq(){
        Motorcycle v = new Motorcycle();

        assertEquals(TransmissionType.SEQUENTIAL, v.getTransmissionType());
    }
    @Test
    public void motorCycleTest(){
        Motorcycle v = new Motorcycle(5);
        assertEquals(5, v.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, v.getTransmissionType());
    }

}
