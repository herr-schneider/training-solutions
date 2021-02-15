package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("No enought space!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getValue();
    }

    public Passenger findPassengerByName(Passenger passenger) {
        for (Passenger searched : passengers) {
            if (searched.getName().equals(passenger.getName())) {
                return searched;
            }
        }
        throw new IllegalArgumentException("Nem kell kivétel!");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();
        for (Passenger searched : passengers) {
            result.add(searched.getName());
            }
        Collections.sort(result);
        return result;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger searched : passengers) {
            sum += searched.getCruiseClass().getValue();
        }

        return sum;
    }



    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
