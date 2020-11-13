package week3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Operation {
    int left;
    int right;

    public int getResult() {
        return left + right;
    }

      public Operation (String input) {
        int plus = input.indexOf("+");
        left = Integer.parseInt(input.substring(0, plus));
        right = Integer.parseInt(input.substring(plus + 1));
    }
}