package week05;

public class CelestialCoordinates {
    private final String coordinates;

    public CelestialCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "CelestialCoordinates{" + "coordinates='" + coordinates + '\'' + '}';
    }
}
