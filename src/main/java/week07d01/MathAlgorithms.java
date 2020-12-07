package week07d01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class MathAlgorithms {

    static Integer[] prims = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271};
    static List<Integer> primNumbers = Arrays.asList(prims);

    public static boolean isPrime(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Try with a positive number!");
        }
        boolean result = false;
        for (Integer num : primNumbers) {
            if (num == x) {result = true;}
        }
    return result;
    }
}
