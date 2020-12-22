package week09d02;

public class FibCalculator {

    public long sumEvents(int bount) {
        int n = 2;
        int nMinus = 1;
        int temp = 0;
        long result = 0;
        while ((n + nMinus) < bount) {
            if (n % 2 == 0) {
                result += n;
            }
            temp = n + nMinus;
            nMinus = n;
            n = temp;
        }
        return result;
    }


}


