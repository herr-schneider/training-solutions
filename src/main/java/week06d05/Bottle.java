package week06d05;

public class Bottle {
    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type) {
        this.type = type;
    }

    public Bottle(BottleType type, int filledUntil) {
        this.type = type;
        this.filledUntil = filledUntil;
    }

    public void fill(int fillAmount){
        if (this.type.getMaximumAmount() < (this.filledUntil + fillAmount)) {throw new IndexOutOfBoundsException("Too much");}
        this.filledUntil = this.filledUntil + fillAmount;
    }

    public static Bottle of(BottleType type){
        return new Bottle(type);
    }
}
