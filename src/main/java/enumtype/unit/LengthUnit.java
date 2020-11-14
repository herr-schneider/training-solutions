package enumtype.unit;

public enum LengthUnit {
    MM(true, 1),
    CM(true, 10),
    M(true, 1000),
    YARD(false, 914),
    FOOT(false, 305),
    INCH(false, 25.4);

    private boolean isSI;
    private double valueInMm;

    LengthUnit (boolean isSI, double valueInMm) {
        this.isSI = isSI;
        this.valueInMm = valueInMm;
    }

    public boolean isSI() {
        return isSI;
    }

    public double getValueInMm() {
        return valueInMm;
    }

}
