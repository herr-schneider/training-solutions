package activitytracker;

import java.time.LocalDate;

public class TrackPoint {
    private long id;
    private LocalDate time;
    private double lat;
    private double lod;

    public TrackPoint(LocalDate time, double lat, double lod) {
        this.time = time;
        this.lat = lat;
        this.lod = lod;
    }

    public long getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLod() {
        return lod;
    }

    @Override
    public String toString() {
        return "TrackPoint{" +
                "id=" + id +
                ", time=" + time +
                ", lat=" + lat +
                ", lod=" + lod +
                '}';
    }
}
