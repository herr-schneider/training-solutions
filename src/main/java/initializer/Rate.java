package initializer;

public class Rate {
    Currency currency;
    double conversionFactor;

    public Rate(Currency currency, double conversionFactor){
     this.currency = currency;
     this.conversionFactor = conversionFactor;
    }

    public Rate(Currency currency){ // extra enum
        this.currency = currency;
        this.conversionFactor = currency.getDefaultConversionFactor();
    }

    public Currency getCurrency(){
        return currency;
    }

    public double getConversionFactor(){
        return  conversionFactor;
    }
}
