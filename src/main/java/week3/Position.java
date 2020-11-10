package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Position {
    private String name;
    private int bonus;


    public Position (String name, int bonus){
        this.name = name;
        this.bonus = bonus;
    }

    private String getName() {
        return name;
    }

    private int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {

        Position ceo = new Position("ceo", 150000);
        Position boss = new Position("boss", 100000);
        Position director = new Position("director", 60000);

        List<Position> positions = Arrays.asList(ceo, boss, director);

        /*List positions = new ArrayList<>();

        positions.add(new Position("ceo", 150000));
        positions.add(new Position("boss", 100000));
        positions.add(new Position("director", 60000)); */

        for (Position position : positions) {
            if (position.getBonus() > 100000){
                System.out.println(position.getName());
            }
        }


    }
}
