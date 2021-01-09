package Activity_tracker;

public class ActivityWithoutTrack implements Activity {
    ActivityType activityType;

    public ActivityWithoutTrack( ActivityType activityType) {
        this.activityType = activityType;
    }

    public double getDistance() {
        return 0.0;
    }

    public ActivityType getType() {
        return activityType;
    }
}
