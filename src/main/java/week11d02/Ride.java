package week11d02;

public class Ride {

    private int day;
    private int numberOfRide;
    private int distance;

    public Ride() {
        super();
    }

    public Ride(int day, int numberOfRide, int distance) {
        this.day = day;
        this.numberOfRide = numberOfRide;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getDistance() {
        return distance;
    }
}
