package week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        int result = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt((String.valueOf(number.charAt(i))));
            if (digit != 0) {
                if (n % digit == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public int findDivisors2(int n) {
        int result = 0;
        String number = Integer.toString(n);
        for (char c : number.toCharArray()) {
            int digit = Integer.parseInt(Character.toString(c));
            if (digit != 0) {
                if (n % digit == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public int findDivisorsMyOwn(int n) {
        if (n > 1000) {
            return findDivisors1000(n);
        }
        if (n > 100) {
            return findDivisors100(n);
        }
        if (n > 10) {
            return findDivisors10(n);
        }
        return 0;
    }

    public int findDivisors1000(int n) {
        int result = 0;
        int thousand = n / 1000;
        int hundred = (n - thousand * 1000) / 100;
        int deca = (n - hundred * 100) / 10;
        int single = n - (hundred * 100 + deca * 10);
        if (n % thousand == 0) {
            result++;
        }
        if (n % hundred == 0) {
            result++;
        }
        if (n % deca == 0) {
            result++;
        }
        if (n % single == 0) {
            result++;
        }
        return result;
    }

    public int findDivisors100(int n) {
        int result = 0;
        int hundred = n / 100;
        int deca = (n - hundred * 100) / 10;
        int single = n - (hundred * 100 + deca * 10);
        if (n % hundred == 0) {
            result++;
        }
        if (n % deca == 0) {
            result++;
        }
        if (n % single == 0) {
            result++;
        }
        return result;
    }

    public int findDivisors10(int n) {
        int result = 0;
        int deca = n / 10;
        int single = n - (+deca * 10);

        if (n % deca == 0) {
            result++;
        }
        if (n % single == 0) {
            result++;
        }
        return result;
    }
}
