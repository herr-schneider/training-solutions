package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    private List<Robot> navigationList = new ArrayList<>();
    private RobotCoordinates robotCoordinates = new RobotCoordinates(0.0,0.0);



    public Robot() {}

    private Robot(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    public Robot go(int meter){
        this.distance = this.distance + meter;
        return this;
    }

    public Robot rotate(int angle){
        this.azimut = this.azimut + angle;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<Robot> getNavigationList() {
        return navigationList;
    }

    public Robot registerNavigationPoint() {
        new Robot(distance, azimut);
        navigationList.add(new Robot(distance, azimut));
        return this;
    }

    public Robot actualCoordinates(){
        double azimutRad = Math.toRadians(azimut);
        robotCoordinates = new RobotCoordinates(
                Math.round((robotCoordinates.getX()+Math.cos(azimutRad)*distance)*1000)/1000.0,
                Math.round((robotCoordinates.getY()+Math.sin(azimutRad)*distance)*1000)/1000.0);
        return this;
    }

    public RobotCoordinates getRobotCoordinates(){
        return robotCoordinates;
    }
    @Override
    public String toString() {
        return "distance: " + distance + " azimut: " + azimut;
    }
}
