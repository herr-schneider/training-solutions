


package week08d01;

public class Sultan {
    private int[] doorStatus = new int[100];

    public void reset() {
        for (int s = 0; s < 100; s++) {
            doorStatus[s] = 0;
        }

    }

    public void openDoors() {
        for (int i = 1; i < doorStatus.length; i++) {
            for (int j = i; j < doorStatus.length; j += i) {
                doorStatus[j] = doorStatus[j] + 1;
            }
        }
    }

    public void printTheResult() {
        for (int i = 1; i < doorStatus.length; i++) {
            System.out.print("Az" + i + ". zárka nyitva:");
            if (doorStatus[i] % 2 == 0) {
                System.out.println("zárva");
            } else {
                System.out.println("nyitva");
            }
        }
    }
}
