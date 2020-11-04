package array;

import java.util.Scanner;

public class ArrayHandler {

       public boolean contains(int[] source, int itemToFind) {
            for (int item : source) {
                if (item == itemToFind) {
                    return true;
                }
            }
            return false;
        }

        public int find(int[] source, int itemToFind) {
            for (int i = 0; i < source.length; i++) {
                if (source[i] == itemToFind) {
                    return i;
                }
            }
            return -1;
        }

        public static void main(String[] args) {

            ArrayHandler arrayHandler = new ArrayHandler();

            int [] array = {1, 2, 3, 5, 6};

            System.out.println("Is there?");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println(arrayHandler.contains(array, num));

            System.out.println("Which?");
            num = scanner.nextInt();
            scanner.nextLine();
            System.out.println(arrayHandler.find(array, num));
        }
    }

