package week07d05;

public class Car extends Vehicle{

    public Car(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Car(int numberOfGears) {
        this(numberOfGears, TransmissionType.AUTOMATIC);
    }

}
