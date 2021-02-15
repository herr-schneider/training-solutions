package exam03;

public enum CruiseClass {

    LUXURY(300_000),
    FIRST(180_000),
    SECOND(100_000);

    private double value;

    CruiseClass (double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}