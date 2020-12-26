package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
    private final CanCarryGoods canCarryGoods;
    private final CanCarryPassengers canCarryPassengers;

    public FerryBoat(int maxCargo, int maxPassengers) {
        canCarryGoods = new CanCarryGoodsBehaviour(maxCargo);
        canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
    @Override
    public int loadPassenger(int passengers){
        return canCarryPassengers.loadPassenger(passengers);
    }


    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }
}
