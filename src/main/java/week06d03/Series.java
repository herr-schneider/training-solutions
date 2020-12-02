package week06d03;

import java.util.ArrayList;
import java.util.List;

public class Series {

    public SeriesType calculateSeriesType(List<Integer> list) {
        isValid(list);
        int counterMin = 0;
        int counterMax = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int elementOfList : list) {
            if (elementOfList < min) {
                min = elementOfList;
                counterMin++;
            }
            if (elementOfList > max) {
                max = elementOfList;
                counterMax++;
            }
        }

        if (counterMax == list.size()) {return SeriesType.INCREASING;}
        else if (counterMin == list.size()) {return SeriesType.DECREASING;}
        else {return SeriesType.RANDOM;}
    }

    public void isValid(List<Integer> list){
        if (list == null || list.size()<2){throw new IllegalArgumentException("Nem jó");}
    }
}
