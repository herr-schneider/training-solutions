package week0703;

import java.util.List;

public class NumberList {

    public boolean isIncreasing (List<Integer> inputList){
        int j=Integer.MIN_VALUE;
        for (int i : inputList) {
            if (i<j) {return false;}
            j=i;
        }
        return true;
    }
}
