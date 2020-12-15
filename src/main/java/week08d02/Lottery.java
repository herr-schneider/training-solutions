package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers(int interval, int number, int s) {
        List<Integer> winner = new ArrayList<>();
        int before = 0;
        int actual = 0;
        for (int i = 1; i < number+1; i++) {
            actual = new Random(s).nextInt(interval) + 1;
            if (actual != before) {
                winner.add(actual);
            } else {
                i = i - 1;
            }
            before = actual;
        }
        return winner;
    }

    public List<Integer> sort(int number, int interval, int s){
        List<Integer> winner = new ArrayList<>();
        int before = 0;
        int actual = 0;
        for (int i = 1; i < number+1; i++) { // while (winner.size() < 5)
            actual = new Random(s).nextInt(interval) + 1;
            if (winner.contains(actual)) {
                winner.add(actual);
            } else {
                i = i - 1;
            }
        }
        return winner;
    }

    public List<Integer> get5Numbers() {
        List<Integer> winner = new ArrayList<>();
        int before = 0;
        int actual = 0;
        for (int i = 1; i < 6; i++) {
            actual = new Random().nextInt(89) + 1;
            if (actual != before) {
                winner.add(actual);
            } else {
                i = i - 1;
            }
            before = actual;
        }
        return winner;
    }
    public void printNumbers(List<Integer> winner) {
        for (int i : winner) {
            System.out.println(i);
        }
    }

}
