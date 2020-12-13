package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{

    public AxeWarrior(Point pos, Random random) {
        this.point = pos;
        this.r = random;
    }


    public int getActualSecondaryDamage(){
        return r.nextInt(19)+1;
    }

    public void secondaryAttack(Character enemy){
        if (enemy.getPosition().distance(this.getPosition())<2) {
            hit(enemy, getActualSecondaryDamage());
        }
    }
}
