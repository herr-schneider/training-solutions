package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(weekdays[2]);
        System.out.println(weekdays.length);

        int[] two = new int[5];

        for (int i =0; i < two.length; i++) {
            int temp = 1;
            for (int j =0; j < i; j++) {
            temp = temp *2;
        }
            two[i] = temp;
        }

        for (int num : two) {
        System.out.println(num);
        }


    }
}
