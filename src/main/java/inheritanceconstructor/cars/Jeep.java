package inheritanceconstructor.cars;

public class Jeep extends Car{
    double extraCapacity;
    double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel){
        super(fuelRate, fuel, tankCapacity);
        //if (fuel > tankCapacity) {throw new IllegalArgumentException("Tank capacity is less than fuel!");}
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }
    public void modifyFuelAmount(double fuel){
        this.fuelRate += fuel;
    }
    public void drive(int km) {// csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        if ((fuel+extraFuel)<(fuelRate * km/100)) {throw new IllegalArgumentException("Not enough fuel available!");}
        if (extraFuel > (fuelRate * km)) {
            this.extraFuel -= (fuelRate * km/100);
        } else {
            fuel -= (double) ((fuelRate * km/100) - this.extraFuel);
            this.extraFuel = 0.0;
        }
    }

    public double calculateRefillAmount() {//kiszámolja, mennyit lehet tankolni
        return super.calculateRefillAmount()+extraFuel;}

    public double getExtraFuel(){
        return extraFuel;
    }
}
