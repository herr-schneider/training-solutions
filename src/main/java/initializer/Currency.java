package initializer;

public enum Currency {
    HUF(1), EUR(360), SFR(17), GBP(400), USD(310);

    private double defaultRate;

    private Currency(double defaultRate) {}

    public double getDefaultConversionFactor(){
        return defaultRate;
    }
}
