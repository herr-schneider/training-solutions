package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{
    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int loadPassenger(int passengers) {
        if (this.maxPassengers<passengers) {this.passengers=maxPassengers;}
        else {this.passengers = passengers;}
        return passengers-maxPassengers<0 ? 0 : passengers-maxPassengers;
    }

    public int getPassengers() {
        return passengers;
    }
}
