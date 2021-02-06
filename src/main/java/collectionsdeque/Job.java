package collectionsdeque;

public class Job implements Comparable {
    private int priority;
    private String name;
    private boolean urgent;

    public boolean isUrgent() {
        return urgent;
    }

    public Job(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public Job(int priority, String name, boolean urgent) {
        this(priority, name);
        this.urgent = urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getJobDescription() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((Job) (o)).getPriority();
    }
}
