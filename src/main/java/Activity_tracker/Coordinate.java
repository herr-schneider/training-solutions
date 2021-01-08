package Activity_tracker;

public class Coordinate {
    private final int latitude;
    private final int longitude;

    public Coordinate(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
