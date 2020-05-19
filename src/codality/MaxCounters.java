package codality;

import javax.swing.text.MaskFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxCounters {
    public static void main(String [] args){

        MaxCounters maxCounters = new MaxCounters();
        int[] result = new int[]{3,2,2,4,2};
        int [] actualResult = maxCounters.solution(5,new int[]{3,4,4,6,1,4,4});
        assert result == actualResult;

        result = new int[]{0};
        actualResult = maxCounters.solution(1,new int[]{2});
        assert result == actualResult;

        result = new int[]{1};
        actualResult = maxCounters.solution(1,new int[]{1});
        assert result == actualResult;

    }

    public int[] solution(int N, int[] A) {

        int [] counters = new int[N];
        int currentMax =0;
        int currentMin = 0;
        for (int i = 0; i < A.length; i++) {
            int counterToIncrement = A[i];
            if (counterToIncrement == N+1){
                currentMin = currentMax;
            }else{
                if (counters[counterToIncrement-1]< currentMin){
                    counters[counterToIncrement-1] = currentMin;
                }
                counters[counterToIncrement-1] = counters[counterToIncrement-1] +1;
                if (counters[counterToIncrement-1]> currentMax){
                    currentMax = counters[counterToIncrement-1];
                }
            }
        }
        for (int i = 0; i <counters.length ; i++) {
            if(counters[i]<currentMin){
                counters[i]=currentMin;
            }
        }
        return counters;
    }


}
