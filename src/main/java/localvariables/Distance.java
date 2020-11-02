package localvariables;

public class Distance {
    private double distanceInKm;
    private boolean exact;

    public boolean isExact() {
        return exact;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void Distance(double distanceInKm, boolean exact) {
        this.distanceInKm = distanceInKm;
        this.exact = exact;
    }
}
