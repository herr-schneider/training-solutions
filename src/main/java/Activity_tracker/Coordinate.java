package Activity_tracker;

public class Coordinate {
    private final double latitude;
    private final double longitude;


    public Coordinate(double latitude, double longitude) {
        if (latitude<-91 || latitude > 90 || longitude<-180 || longitude>180){throw new IllegalArgumentException();}
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
