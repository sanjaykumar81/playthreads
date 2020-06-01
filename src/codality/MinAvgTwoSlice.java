package codality;

import java.util.Arrays;
import java.util.Collections;

public class MinAvgTwoSlice {
    public static void main(String[] args) {

        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        System.out.println(minAvgTwoSlice.solution(new int[]{4,2,2,5,1,5,8}));
    }

        public int solution(int[] A) {
            int [] prefixSum = buildPrefixSums(A);
            Arrays.stream(prefixSum).forEach(x-> System.out.print(x + " "));
            System.out.println();
            return findMinAvgSlice(A, prefixSum);
        }

    private int findMinAvgSlice(int[] A, int[] prefixSum) {
        int startPosition=0;
        float min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length-1 ; i++) {
            for (int j = i+1; j < A.length  ; j++) {
                float average = count_total(prefixSum,i,j) /((j-i+1)*1.0f);
                System.out.print("i: "+ i +"j: "+j+" Average : " + average);
                if(min>average){
                    min = average;
                    startPosition =i;
                }
                System.out.println(", Min: "+ min);
            }
        }
        return startPosition;
    }
    private int count_total(int[] prefixSum, int lef_position, int right_position) {

        return prefixSum[right_position+1] - prefixSum[lef_position];
    }

    public int[] buildPrefixSums(int [] A){
            int [] prefixSum = new int[A.length+1];

            prefixSum[0] = 0;
            for (int i = 1; i < A.length +1 ; i++) {
                prefixSum[i] = prefixSum[i-1] + A[i-1];
            }
            return prefixSum;
        }
}
