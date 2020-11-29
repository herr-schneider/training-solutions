package methodstructure.bmi;

public class BodyMass {
    double weight, height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight/Math.pow(height,2);
    }

    public boolean isThinnerThan(BodyMass comp) {
                if (this.bodyMassIndex() > comp.bodyMassIndex()) {
                    return false;
        }
                return  true;
    }

    public BmiCategory body() {
        if (bodyMassIndex()<18) {return BmiCategory.UNDERWEIGHT;}
        else if (bodyMassIndex()>25) {return BmiCategory.OVERWEIGHT;}
        else {
            return BmiCategory.NORMAL;
        }
    }
}
