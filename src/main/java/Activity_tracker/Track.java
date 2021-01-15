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

    public Coordinate findMinimumCoordinate() {
        double latitude = 90;
        double longitude = 180;
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < latitude) {
                latitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < longitude) {
                longitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(latitude, longitude);
    }

    public double getRectangleArea() {
        return (findMaximumCoordinate().getLatitude()-findMinimumCoordinate().getLatitude()) *
                (findMaximumCoordinate().getLongitude()-findMinimumCoordinate().getLongitude());
       /*  double lat1 = trackPoints.get(0).getCoordinate().getLatitude() + 90;
        double lat2 = trackPoints.get(1).getCoordinate().getLatitude() + 90;
        double lat3 = trackPoints.get(2).getCoordinate().getLatitude() + 90;
        double lat4 = trackPoints.get(3).getCoordinate().getLatitude() + 90;
        double lon1 = trackPoints.get(0).getCoordinate().getLongitude() + 180;
        double lon2 = trackPoints.get(1).getCoordinate().getLongitude() + 180;
        double lon3 = trackPoints.get(2).getCoordinate().getLongitude() + 180;
        double lon4 = trackPoints.get(3).getCoordinate().getLongitude() + 180;
        double a = Math.sqrt(Math.pow(Math.abs(lat1 - lat2), 2) + Math.pow(Math.abs(lon1 - lon2), 2));
        double b = Math.sqrt(Math.pow(Math.abs(lat3 - lat4), 2) + Math.pow(Math.abs(lon3 - lon4), 2));
        double c = Math.sqrt(Math.pow(Math.abs(lat2 - lat3), 2) + Math.pow(Math.abs(lon2 - lon3), 2));
        double d = Math.sqrt(Math.pow(Math.abs(lat4 - lat1), 2) + Math.pow(Math.abs(lon4 - lon1), 2));
        double e = Math.sqrt(Math.pow(Math.abs(lat1 - lat3), 2) + Math.pow(Math.abs(lon1 - lon3), 2));
        double f = Math.sqrt(Math.pow(Math.abs(lat2 - lat4), 2) + Math.pow(Math.abs(lon2 - lon4), 2));
        return e * f * Math.sin(90) / 2;
        //return (a + b) * (c + d) / 4;

        /* return trackPoints.get(0).getDistanceFrom(trackPoints.get(1))+
                trackPoints.get(1).getDistanceFrom(trackPoints.get(2))+
                trackPoints.get(2).getDistanceFrom(trackPoints.get(3))+
                trackPoints.get(3).getDistanceFrom(trackPoints.get(0)); */
    }

    public Coordinate findMaximumCoordinate() {
        double latitude = -90;
        double longitude = -180;
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > latitude) {
                latitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > longitude) {
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
