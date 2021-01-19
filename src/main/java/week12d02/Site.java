package week12d02;

public class Site {
    int evenOdd;
    int length;
    Fence fence;

    public Site(int evenOdd, int length, Fence fence) {
        this.evenOdd = evenOdd;
        this.length = length;
        this.fence = fence;
    }

    public int getEvenOdd() {
        return evenOdd;
    }

    public int getLength() {
        return length;
    }

    public Fence getFence() {
        return fence;
    }
}
