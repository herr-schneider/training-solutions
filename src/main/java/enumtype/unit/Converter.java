package enumtype.unit;

import java.util.Scanner;

public class Converter {
    private double unit;
    private double outUnit;
    private LengthUnit lengthUnit;
    String fromUnit;

    public double Converting(double unit, String fromUnit) {
        this.fromUnit = fromUnit;
        if (fromUnit == "mm") {
            LengthUnit lenghtUnit = LengthUnit.MM;
            outUnit = (unit / lenghtUnit.getValueInMm());
        }

        if (fromUnit == "cm") {
            LengthUnit lenghtUnit = LengthUnit.CM;
            outUnit = (unit / lenghtUnit.getValueInMm());
        }

        if (fromUnit == "m") {
            LengthUnit lenghtUnit = LengthUnit.M;
            outUnit = (unit / lenghtUnit.getValueInMm());
        }

        if (fromUnit == "yard") {
            LengthUnit lenghtUnit = LengthUnit.YARD;
            outUnit = (unit / lenghtUnit.getValueInMm());
        }

        if (fromUnit == "foot") {
            LengthUnit lenghtUnit = LengthUnit.FOOT;
            outUnit = (unit / lenghtUnit.getValueInMm());
        }

        if (fromUnit == "inch") {
            outUnit = (unit / lengthUnit.INCH.getValueInMm());
        }

        return outUnit;
    }
}