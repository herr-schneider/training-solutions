package exam02.photo;

public enum Quality {
    NO_STAR(0), ONE_STAR(1), TWO_STAR(2);

    private int numberOfStar;

    Quality(int numberOfStar) {
        this.numberOfStar = numberOfStar;
    }

    public int getNumberOfStar() {
        return numberOfStar;
    }
}
