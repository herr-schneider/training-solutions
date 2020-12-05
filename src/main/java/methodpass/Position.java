package methodpass;

public class Position {
    private final double x;
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Position pos){
        return Math.sqrt(Math.pow((this.x-pos.getPosX()),2)+Math.pow((this.y-pos.getPosY()),2));
    }

    public double getPosX() {
        return x;
    }

    public double getPosY() {
        return y;
    }
}
