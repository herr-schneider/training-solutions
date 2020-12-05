package methodpass;

public class Trooper {
    private String name;
    private Position pos = new Position(0,0);

    public Trooper(){}

    public Trooper(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return pos;
    }

    public void changePosition(Position targetPos) {
        if (targetPos == null) {
            throw new IllegalArgumentException();
        }
        if (this.getPosition() == null) {
            pos = new Position(targetPos.getPosX(), targetPos.getPosY());
        } else {
            pos = new Position(this.getPosition().getPosX() + targetPos.getPosX(), this.getPosition().getPosY() + targetPos.getPosY());
        }
    }

    public double distanceFrom(Position target) {
        return this.getPosition().distanceFrom(target);
    }
}
