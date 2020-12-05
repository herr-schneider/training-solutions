package staticattrmeth.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {
    long trxValue;
    static BigDecimal sumOfTransaction;
    static int numOfTransaction;
    static List<Long> listOfTrx = new ArrayList<>();

    public static void initTheDay() {
        sumOfTransaction = new BigDecimal(0);
        numOfTransaction = 0;
        listOfTrx.clear();

    }

    public static BigDecimal averageOfTransaction() {
        return numOfTransaction == 0 ? new BigDecimal("0") : sumOfTransaction.divide(new BigDecimal(Integer.toString(numOfTransaction)),0, RoundingMode.HALF_UP); // Stolen from Traning360
    }

    public static long getCurrentMinValue() {
        long result = Long.MAX_VALUE;
        for (Long trx : listOfTrx) {
            if (trx < result) {
                result = trx;
            }
        }
        return numOfTransaction == 0 ?  0 : result; // Stolen from Traning360
    }

    public static long getCurrentMaxValue() {
        long result = Long.MIN_VALUE;
        for (Long trx : listOfTrx) {
            if (trx > result) {
                result = trx;
            }
        }
        return numOfTransaction == 0 ?  0 : result; // Stolen from Traning360
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTransaction;
    }


    public BankTransaction(long trxValue) {
        listOfTrx.add(trxValue);
        sumOfTransaction = sumOfTransaction.add(new BigDecimal(Long.toString(trxValue)));
        numOfTransaction++;
        this.trxValue = trxValue;
    }

    public long getTrxValue() {
        return trxValue;
    }
}