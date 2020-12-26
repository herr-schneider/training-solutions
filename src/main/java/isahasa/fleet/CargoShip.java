package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods{
    CanCarryGoods canCarryGoods;

    public CargoShip(int maxCargo) {
        canCarryGoods = new CanCarryGoodsBehaviour(maxCargo);
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
