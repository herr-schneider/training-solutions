package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private long balance;
    private static List<Rate> rates = new ArrayList<>();


    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        this.rates = rates;
        this.balance = (long) (balance*Converter(currency));
    }

    private double Converter(Currency currency){
        double result = currency.getDefaultConversionFactor();
        for (Rate rate : rates) {
            if (rate.getCurrency() == currency) {
                result = rate.conversionFactor;
            }
        }
        return  result;
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }


    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        if (amount*Converter(currency) > balance) {return false;}
        this.balance = (long) (this.balance - amount*Converter(currency));
        return true;
    }

    public boolean payment(long amount) {
        if (amount > balance) {return false;}
        balance = balance - amount;
        return true;
    }
}
