package codality;

import java.util.Arrays;

public class AbsoluteMinDiff {

    public static void main(String [] args){
    AbsoluteMinDiff minDiff = new AbsoluteMinDiff();
    assert 1 == minDiff.solution(new int[]{3,1,2,4,3});
    }

    public int solution(int[] A) {

        if(A.length ==2){
            return Math.abs(A[0]-A[1]);
        }
        int total=0;
        for (int a: A) {
            total = a + total;
        }
        int minDiff = 999999999;
        int leftSum = 0;
        int rightSum = 0;
        int tempDiff =0;
        for (int i = 0; i <A.length-1 ; i++) {
            leftSum = leftSum +A[i];
            rightSum = total -leftSum;
            tempDiff = Math.abs(rightSum- leftSum);
            if (tempDiff ==0){
                return 0;
            }
            if (minDiff> tempDiff){
                minDiff = tempDiff;
            }

        }

        return minDiff;
    }
}
