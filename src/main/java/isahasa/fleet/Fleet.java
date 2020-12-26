package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> fleet = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public Fleet() {
    }

    public Fleet(List<Ship> fleet) {
        this.fleet = fleet;
    }

    public void addShip(Ship ship) {
        fleet.add(ship);
    }

    public void loadShip(int passenger, int cargo) {
        waitingPersons = passenger;
        waitingCargo = cargo;
        for (Ship ship : fleet) {
            if (ship instanceof Liner) {waitingPersons = ((Liner) ship).loadPassenger(waitingPersons);}
            if (ship instanceof CargoShip) {waitingCargo = ((CargoShip) ship).loadCargo(waitingCargo);}
            if (ship instanceof FerryBoat) {waitingPersons = ((FerryBoat) ship).loadPassenger(waitingPersons);
                waitingCargo = ((FerryBoat) ship).loadCargo(waitingCargo);}
            }
        }

        public int getWaitingPersons () {
            return waitingPersons;
        }

        public int getWaitingCargo () {
            return waitingCargo;
        }
    }
