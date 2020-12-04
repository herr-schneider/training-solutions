package methodoverloading;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds){
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    }

    public Time(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }
    public Time(int hours){
        this.hours = hours;
    }

    public Time(Time time){
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();

    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time){
        return (this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds == time.getSeconds());
    }
    public boolean isEqual(int hours, int minutes, int seconds){
        return (this.hours == hours && this.minutes == minutes && this.seconds == seconds);
    }
    public boolean isEarlier(Time time){
        if (this.hours < time.getHours()) {return true;}
        if (this.hours == time.getHours() && this.minutes < time.getMinutes()) {return true;}
        if (this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds < time.getSeconds()) {return true;}
        return false;
    }
    public boolean isEarlier(int hours, int minutes, int seconds){
        if (this.hours < hours) {return true;}
        if (this.hours == hours && this.minutes < minutes) {return true;}
        if (this.hours == hours && this.minutes == minutes && this.seconds < seconds) {return true;}
        return false;
    }
}
