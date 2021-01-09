package Activity_tracker;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity){
        activities.add(activity);
    }
}
