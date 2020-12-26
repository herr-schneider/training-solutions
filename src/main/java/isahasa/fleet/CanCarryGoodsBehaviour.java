package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods{
   private int cargoWeight;
    private int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public int loadCargo(int cargoWeight){
        if (this.maxCargoWeight>cargoWeight) {this.cargoWeight=cargoWeight;}
        else {this.cargoWeight = maxCargoWeight;}
        return cargoWeight-maxCargoWeight<0 ? 0 : cargoWeight-maxCargoWeight;
    }

    public int getCargoWeight(){
        return cargoWeight;
    }
}
