package week08d01;

public class Robot {
    private String controlStr;
    private Position pos = new Position(0, 0);

    public Robot(String controlStr, Position pos) {
        this.pos = pos;
        this.controlStr = controlStr;
    }

    public Robot(String controlStr) {
        this.controlStr = controlStr;
    }

    public String getPosString() {
        return pos.toString();
    }

    public Position getPos() {
        return pos;
    }

    public Position controlIf(char c) {
        int newX = this.pos.getX();
        int newY = this.pos.getY();
        if (c == 'j') {
            newX++;
        }
        if (c == 'b') {
            newX--;
        }
        if (c == 'f') {
            newY++;
        }
        if (c == 'l') {
            newY--;
        }
        return new Position(newX, newY);
    }

    public Position control(char c) {
        int newX = this.pos.getX();
        int newY = this.pos.getY();
        switch (c) {
            case 'j': {
                newX++;
                return new Position(newX, newY);
            }
            case 'b': {
                newX--;
                return new Position(newX, newY);
            }
            case 'f': {
                newY++;
                return new Position(newX, newY);
            }
            case 'l': {
                newY--;
                return new Position(newX, newY);
            }
            default:
                throw new IllegalArgumentException("");
        }
    }


    public Position mover() {
        String controlStr = this.controlStr.toLowerCase();
        for (int i = 0; i < controlStr.length(); i++) {
            pos = control(controlStr.charAt(i));
            System.out.println(pos.toString());
        }
        return pos;
    }

    public Position moverIf() {
        String controlStr = this.controlStr.toLowerCase();
        for (int i = 0; i < controlStr.length(); i++) {
            pos = controlIf(controlStr.charAt(i));
            System.out.println(pos.toString());
        }
        return pos;
    }
}
