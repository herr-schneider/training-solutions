package week13d02;

import java.time.LocalTime;

public class Fly {
    private String name;
    private String type;
    private String target;
    private int hour;
    private int minute;
    LocalTime time;


    public Fly(String name, String type, String target, int hour, int minute) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.hour = hour;
        this.minute = minute;
    }

    public Fly(String name, String type, String target, LocalTime time) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public LocalTime getTime() {return time; }

    @Override
    public String toString() {
        return "Fly{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", target='" + target + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}


