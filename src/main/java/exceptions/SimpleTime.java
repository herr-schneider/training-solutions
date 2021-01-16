package exceptions;

public class SimpleTime {
    //Lehet létrehozni óra és perc megadásával és lehet időpontot megadni "hh:mm" alakú String-el is.


    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        if (isCorrect(hour, minute)) {
            this.hour = hour;
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Unknown error!");
        }
    }

    public boolean isCorrect(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        return true;
    }

    public SimpleTime(String hoursMinutes) {
        if (hoursMinutes == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] hoursMinutesArray = hoursMinutes.split(":");
        try {
            int hour = Integer.parseInt(hoursMinutesArray[0]);
            int minute = Integer.parseInt(hoursMinutesArray[1]);
            if (isCorrect(hour, minute)) {
                this.hour = hour;
                this.minute = minute;
            }
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return hour < 10 ? "0" + hour + ":" + minute : hour + ":" + minute;
    }
}
