package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {
    Point point;
    int hitPoint = 100;
    Random r = new Random();

    public boolean isAlive() {
        return (hitPoint > 0);
    }

    public Point getPosition(){
        return point;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    protected int getActualPrimaryDamage() {
        return r.nextInt(9) + 1;
    }

    private int getActualDefence() {
        return r.nextInt(5);
    }

    private void decreaseHitPoint(int diff) {
        this.hitPoint -= diff;
    }

    protected void hit(Character enemy, int damage) {
        if (enemy.getActualDefence() < damage) {
            enemy.decreaseHitPoint(damage);
        }

    }

    public void primaryAttack(Character enemy) {
    hit(enemy,this.getActualPrimaryDamage());
    }

    public abstract void secondaryAttack(Character enemy);
}
