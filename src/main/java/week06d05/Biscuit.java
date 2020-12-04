package week06d05;

public class Biscuit {
    private static int biscuitToBeSold;
    private BiscuitType biscuitType;
    private int gramAmount;


    public Biscuit(BiscuitType biscuitType, int gramAmount) {
        if (gramAmount < 1) {throw new IllegalArgumentException("Incorrect amount!");}
        this.biscuitType = biscuitType;
        this.gramAmount = gramAmount;
        biscuitToBeSold++;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount) {
        biscuitToBeSold++;
        return new Biscuit(biscuitType, gramAmount);
    }

    @Override
    public String toString() {
        return biscuitType.toString() + " " + gramAmount;
    }
}
