package week10d05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    public int findMinSum(int[] arr){
        int result = 0;
        List<Integer> list= new ArrayList<>(arr);
        Collections.sort(list);
        for (int i=0; i<4; i++){
            result = result + list.get(i);
        }
        return result;
    }
}
