package exceptions;

public class SimpleTime {
    //Lehet létrehozni óra és perc megadásával és lehet időpontot megadni "hh:mm" alakú String-el is.
    //Legyen felüldefiniálva a toString úgy, hogy "hh:mm" alakú időt adjon.
    //Legyen getHour, és getMinute metódusa is.

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String hoursMinutes) {
        String[] hoursMinutesArray = hoursMinutes.split(":");
        this.hour = Integer.parseInt(hoursMinutesArray[0]);
        this.minute = Integer.parseInt(hoursMinutesArray[1]);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
