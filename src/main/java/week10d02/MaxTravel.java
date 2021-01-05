package week10d02;


import java.util.List;

public class MaxTravel {

    public final int MAX = 30;

    private int[] busStops = new int[MAX];


    public int getMaxIndex(List<Integer> passengerList) {
        int result = 0;
        int maxValue = 0;

        for (int i = 0; i < passengerList.size(); i++) {
            busStops[passengerList.get(i)]++;
        }
        for (int i = 0; i < busStops.length; i++) {
            if (busStops[i] > maxValue) {
                maxValue = busStops[i];
                result = i;
            }
        }
        return result;
    }
}

