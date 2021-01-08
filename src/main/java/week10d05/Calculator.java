package week10d05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public int findMinSum(int[] arr) {
        if (arr.length < 4) {throw new IllegalArgumentException("");}
        int result = 0;
        Arrays.sort(arr);
        for (int i = 0; i < 4; i++) {
            result = result + arr[i];
        }
        return result;
    }
}


