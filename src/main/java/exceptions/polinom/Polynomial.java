package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientsByWord) {
        if (coefficientsByWord == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] coefficientsByDouble = new double[coefficientsByWord.length];
        try {
            for (int i = 0; i < coefficientsByWord.length; i++) {
                coefficientsByDouble[i] = Double.parseDouble(coefficientsByWord[i]);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
        this.coefficients = coefficientsByDouble;
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x, (double) n - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
