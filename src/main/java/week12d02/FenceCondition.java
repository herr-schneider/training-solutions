package week12d02;

public class FenceCondition {

    private Fence fence;
    private int numberOfFence;


    public FenceCondition(Fence fence, int numberOfFence) {
        this.fence = fence;
        this.numberOfFence = numberOfFence;
    }

    public Fence getFence() {
        return fence;
    }

    public int getNumberOfFence() {
        return numberOfFence;
    }

    public void setFence(Fence fence) {
        this.fence = fence;
    }

    public void setNumberOfFence(int numberOfFence) {
        this.numberOfFence = numberOfFence;
    }

    @Override
    public String toString() {
        return fence + ": " + numberOfFence + " db";
    }
}
