package activitytracker;

import java.time.LocalDateTime;

public class Activity {
    private int id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType activityType;

    public Activity(LocalDateTime startTime, String desc, ActivityType activityType) {
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType activityType) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", activityType=" + activityType +
                '}';
    }
}
