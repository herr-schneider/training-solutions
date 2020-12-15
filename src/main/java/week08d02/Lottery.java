package week08d02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getSortNumbers(List<Integer> winner) {
        Collections.sort(winner);
        return winner;
    }

    public List<Integer> getNumbers(int number, int interval, int s) {
        if (number >= interval){
            throw new IllegalArgumentException("Invalid!");
        }
        List<Integer> winner = new ArrayList<>();
        Random random = new Random(s);
        int actual = 0;
        for (int i = 1; i < number + 1; i++) { // while (winner.size() < 5)
            actual = random.nextInt(interval) + 1;
            if (!winner.contains(actual)) {
                winner.add(actual);
            } else {
                i = i - 1;
            }
        }
        return winner;
    }

    public List<Integer> get5Numbers(int s) { // getNumbers(5, 90, 5);
        List<Integer> winner = new ArrayList<>();
        Random random = new Random(s);
        int actual = 0;
        while (winner.size() < 5) {
            actual = random.nextInt(89) + 1;
            if (!winner.contains(actual)) {
                winner.add(actual);
            }
        }
        return winner;    }

    public void printNumbers(List<Integer> winner) {
        for (int i : winner) {
            System.out.println(i);
        }
    }

}
