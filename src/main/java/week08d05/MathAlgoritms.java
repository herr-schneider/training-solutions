package week08d05;

public class MathAlgoritms {

    public int greatestCommonDivisor(int upperNumber, int lowerNumber) {
        if (upperNumber == lowerNumber) {
            return lowerNumber;
        }
        int lkt = 0;
        int j = Math.min(upperNumber, lowerNumber);
        System.out.println(j);
        for (int i = 1; i <= j; i++) {
            if (upperNumber % i == 0 && lowerNumber % i == 0) {
                lkt = i;

            }
        }
        return lkt;
    }

    public int greatestCommonDivisor2(int upperNumber, int lowerNumber) {
        if (upperNumber == lowerNumber) {
            return lowerNumber;
        }
        int lkt = 0;
        for (int i = 2; i <= upperNumber && i <= lowerNumber; i++) {
            if (upperNumber % i == 0 && lowerNumber % i == 0) {
                lkt = i;
            }
        }
        return lkt;
    }

    public int greatestCommonDivisorBack(int upperNumber, int lowerNumber) {
        if (upperNumber == lowerNumber) {
            return lowerNumber;
        }
        for (int i = Math.min(upperNumber, lowerNumber); i >= 1; i--) {
            if (upperNumber % i == 0 && lowerNumber % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public int Euclidean(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
