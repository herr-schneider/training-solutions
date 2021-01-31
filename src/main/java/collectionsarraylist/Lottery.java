package collectionsarraylist;

import java.util.*;

public class Lottery {
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (!isValid(lotteryType, ballCount)) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        for (int i=0; i<lotteryType; i++){
           numbers.add(new Random().nextInt(ballCount));
        }
        Collections.sort(numbers);
        return numbers;
    }

    public boolean isValid(int lotteryType, int ballCount) {
        if (lotteryType < 0 || ballCount < 0 || lotteryType >= ballCount) {
            return false;
        } else {
            return true;
        }
    }

    public List<Integer> shuffleWinningNumbers(int lotteryType, int ballCount){
        if (!isValid(lotteryType, ballCount)) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> balls= new ArrayList<>();
        for (int i = 1; i <= ballCount; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        List<Integer> winningNumbers = balls.subList(0, lotteryType);
        Collections.sort(winningNumbers);
        return winningNumbers;
    }
}