package operators;

public class Operators {
    int n;

    public Operators(int n) {
        this.n = n;
    }

    public boolean isEven() {
        int num = this.n;
        boolean isEvent = false;
        if (num % 2 == 0) {
            isEvent = true;
        }
        return isEvent;
    }
}
