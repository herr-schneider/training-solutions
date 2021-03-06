package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (rides.size() == 0) {
            rides.add(ride);
        }
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getDay() == ride.getDay() && rides.get(i).getNumberOfRide() < ride.getNumberOfRide()) {
                rides.add(ride);
            } else if (rides.get(i).getDay() < ride.getDay()) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Wrong order of ride!");
            }
        }
    }

    public void addRide2(Ride ride) {
        if (rides.size() == 0) {
            rides.add(ride);
        }
        if (rides.get(rides.size() - 1).getDay() > ride.getDay()) {
            throw new IllegalArgumentException("Wrong order of ride!");
        }

        if (rides.get(rides.size() - 1).getDay() == ride.getDay() && rides.get(rides.size() - 1).getNumberOfRide() < ride.getNumberOfRide()) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Wrong order of ride!");
        }

    }

   public int firstFreeDay() { // müködik
        int result = -1;
        Ride beforeRide = new Ride();
        for (int i = 1; i<rides.size(); i++) {
                if (rides.get(i).getDay()-rides.get(i-1).getDay() > 1){
               result = rides.get(i-1).getDay()+1;
            }
        }
        return rides.get(rides.size()-1).getDay() < 7 ? rides.get(rides.size()-1).getDay()+1 : result;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide3(Ride ride) { // müködik
        if (ride == null) {
            throw new IllegalArgumentException("Ride is null");
        }
        int sizeOfList = rides.size();
        if (sizeOfList == 0) {
            rides.add(ride);
        } else if (rides.get(sizeOfList - 1).getDay() < ride.getDay())  {
            rides.add(ride);
        } else if (rides.get(sizeOfList - 1).getDay() == ride.getDay()
                && rides.get(rides.size() - 1).getNumberOfRide() < ride.getNumberOfRide()){
            rides.add(ride);
        } else{
            System.out.println("nem jó");}

    }

    public int freeDay() {
        int result = -1;
        for (int i = 1; i < rides.get(rides.size()-1).getDay(); i++) {
            for (Ride item : rides) {
                if (i != item.getDay()) {
                    result = i;
                }
            }
        }
        return result;
    }
}
