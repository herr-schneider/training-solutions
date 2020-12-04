package week06d05;

public enum BottleType {

    GLASS_BOTTLE(100), PET_BOTTLE(200);

    private int maximumAmount;

    BottleType(int maximumAmount) {}

    public int getMaximumAmount() {
        return maximumAmount;
    }
}