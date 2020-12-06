package initializer;

import java.util.List;

public class CreditCard {
    long balance;


    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        double factor = 1;
        for (Rate rate : rates) {
            if (rate.getCurrency() == currency) {
                factor = rate.conversionFactor;
            }
        }
        this.balance = (long) (balance*factor);
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }


    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        if (amount*currency.getDefaultConversionFactor() > balance) {return false;}
        balance = (long) (balance - amount*currency.getDefaultConversionFactor());
        return true;
    }

    public boolean payment(long amount) {
        if (amount > balance) {return false;}
        balance = balance - amount;
        return true;
    }
}
