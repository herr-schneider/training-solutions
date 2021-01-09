package Activity_tracker;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int result = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                result++;
            }
        }
        return result;
    }

    public int numberOfWithoutTrackActivities() {
        int result = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                result++;
            }
        }
        return result;
    }

    public List<Report> distancesByTypes() {
        List<Report> results = new ArrayList<>();
        int distance = 0;
        for (ActivityType act : ActivityType.values()) {
            for (Activity activity : activities) {
                if (activity.getType() == act) {
                    distance += activity.getDistance();
                }
            }
            results.add(new Report(act, distance));
        }
        return results;
    }
}

