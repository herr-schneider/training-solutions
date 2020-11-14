package week3;

public class Circle {
    private double r;
    private final double PI = 3.14;

    public Circle(double r){
        this.r = r;
    }

    public double Perimeter() {
        return 2*r*PI;
    }

    public double Area(){
        return Math.pow(r, 2)*PI;
    }

}

