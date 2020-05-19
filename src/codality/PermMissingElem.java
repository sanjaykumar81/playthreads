package codality;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermMissingElem {
    public static void main(String [] args){

        PermMissingElem missingElem = new PermMissingElem();

        System.out.println(missingElem.solution(new int[]{1,2,5,4}));

    }

    public int solution(int[] A) {
        int[] resultArr = new int[A.length+1];

        for (int i = 0; i < A.length; i++) {
            resultArr[A[i]-1] =1;
        }

        for (int i = 0; i < resultArr.length; i++) {
            if(resultArr[i] ==0){
                return i+1;
            }
        }



        return 0;
    }


}
