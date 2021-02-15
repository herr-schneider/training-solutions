package timesheet;

public class RiportLine {
    Project project;
    long time;

    public RiportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }
}
