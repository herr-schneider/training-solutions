package week07d03;

import java.util.List;

public class NumberList {

    public boolean isIncreasing (List<Integer> inputList){
        int j=Integer.MIN_VALUE;
        for (int i : inputList) {  // for int i=1; i < inputList.size(); i++; inputList.get(i-1) < inputList.get(i)
            if (i<j) {return false;}
            j=i;
        }
        return true;
    }
}
