package week10d01;

import java.util.ArrayList;
import java.util.List;

public class Hiking {
    private List<Double> altitude = new ArrayList<>();
    private double coordinateLong;
    private double coordinateVert;

    public Hiking(List<Double> altitude) {
        this.altitude = altitude;
    }

    public Hiking(double... altitude) {

        for (double alt : altitude) {
            this.altitude.add(alt);
        }
    }

    public double getPlusElevation(){
        if (altitude == null || altitude.size() < 2){throw new IllegalArgumentException("Nem jó!");}
        double result = 0;
        for (int i = 1; i<altitude.size(); i++) {
         if ((altitude.get(i)-altitude.get(i-1))>0) {result += (altitude.get(i)-altitude.get(i-1));}
        }
        return result;
    }
}
