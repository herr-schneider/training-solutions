package exam02;

public class ArraySelector {

    public String selectEvens(int[] numbers) {
        if (numbers.length < 1) {
            return "";
        }
        StringBuilder result = new StringBuilder("[");
        result.append(numbers[0]);
        for (int i = 2; i < numbers.length; i += 2) {
            result.append(", " + numbers[i]);
        }
        return result.append("]").toString();
    }
}
