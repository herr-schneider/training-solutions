package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character{
    private int numberOfArrow;

    public Archer(Point pos, Random random) {
        this.numberOfArrow = 100;
        this.r = random;
        this.point = pos;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    public int getActualSecondaryDamage(){
        return r.nextInt(4)+1;
    }
    public void shootingAnArrow(Character enemy){
        numberOfArrow--;
        hit(enemy, getActualSecondaryDamage());

    }

    public void secondaryAttack(Character enemy){
        shootingAnArrow(enemy);
    }
}
