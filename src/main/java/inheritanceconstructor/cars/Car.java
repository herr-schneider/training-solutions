package inheritanceconstructor.cars;

public class Car {
    double fuelRate;
    double fuel;
    double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {throw new IllegalArgumentException("Tank capacity is less than fuel!");}
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {// csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        if (fuel<(fuelRate * km/100)) {throw new IllegalArgumentException("Not enough fuel available!");}
        fuel -= (double) (fuelRate * km/100);
    }

    public double calculateRefillAmount() {//kiszámolja, mennyit lehet tankolni
    return tankCapacity-fuel;
    }

    public double getFuel() {
        return fuel;
    }
}
