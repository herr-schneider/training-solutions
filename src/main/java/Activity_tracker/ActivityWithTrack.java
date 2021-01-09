package Activity_tracker;

public class ActivityWithTrack implements Activity {
    Track track;
    ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    public double getDistance() {
        return track.getDistance();
    }

    public ActivityType getType() {
        return activityType;
    }
}