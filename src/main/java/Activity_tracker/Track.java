package Activity_tracker;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Track() {
        super();
    }

    public Track(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }

    public Coordinate findMinimumCoordinate(){
        double latitude = 90;
        double longitude = 180;
    for (TrackPoint trackPoint : trackPoints) {
        if (trackPoint.getCoordinate().getLatitude() < latitude){
            latitude = trackPoint.getCoordinate().getLatitude();
        }
        if (trackPoint.getCoordinate().getLongitude() < longitude){
            longitude = trackPoint.getCoordinate().getLongitude();
        }
    }
    return new Coordinate(latitude, longitude);
    }
    public double getRectangleArea(){
        double result = 0.0;
        result = trackPoints.get(0).getDistanceFrom(trackPoints.get(1))+
                trackPoints.get(1).getDistanceFrom(trackPoints.get(2))+
                trackPoints.get(2).getDistanceFrom(trackPoints.get(3))+
                trackPoints.get(3).getDistanceFrom(trackPoints.get(0));
    return result;
    }

    public Coordinate findMaximumCoordinate(){
        double latitude = -90;
        double longitude = -180;
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > latitude){
                latitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > longitude){
                longitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(latitude, longitude);
    }

    public double getFullElevation() {
        double result = 0.0;
        double temp = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            temp = trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            if (temp > 0) {
                result += temp;
            }
        }
        return result;
    }

    public double getFullDecrease() {
        double result = 0.0;
        double temp = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            temp = trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            if (temp < 0) {
                result += Math.abs(temp);
            }
        }
        return result;
    }

    public double getDistance() {
        double result = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            result += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return result;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint newTrackPoint) {
        trackPoints.add(newTrackPoint);
    }
}
