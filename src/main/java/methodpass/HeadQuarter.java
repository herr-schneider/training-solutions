package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> listOfTrooper = new ArrayList<>();

    public void addTrooper(Trooper trooper) {
        listOfTrooper.add(trooper);
    }

    public List<Trooper> getTroopers() {
        return new ArrayList<>(listOfTrooper);
    }

    public void moveTrooperByName(String foundTrooper, Position newPos) {
        for (Trooper trooper : listOfTrooper) {
            if (trooper.getName().equals(foundTrooper)) {
                trooper.changePosition(newPos);
            }
        }
    }

    public Trooper moveClosestTrooper(Position target) {
        Trooper closestTrooper = new Trooper();
        double distance = Double.MAX_VALUE;
        for (Trooper trooper : listOfTrooper) {
            if (trooper.distanceFrom(target) < distance) {
                distance = trooper.distanceFrom(target);
                closestTrooper = trooper;
            }
        }
        return closestTrooper;
    }
}
