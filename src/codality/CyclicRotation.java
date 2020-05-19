package codality;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class CyclicRotation {

    public static void main(String[] args){

        CyclicRotation cyclicRotation = new CyclicRotation();
        int [] sol = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6},3);
        System.out.println(sol);


    }

    public int [] solution(int[] A, int K){

        if (A.length == 0){
            return A;
        }

        int actualRotation = K % A.length;

        if (actualRotation ==0){
            return  A;
        }

        int[] postFixArrary = Arrays.copyOfRange(A,0,A.length-actualRotation);
        int[] preFixArrary =  Arrays.copyOfRange(A,A.length-actualRotation,A.length);
        for (int i = 0; i <preFixArrary.length ; i++) {
            A[i] = preFixArrary[i];
        }
        for (int j=0,i = preFixArrary.length; i < A.length ; i++, j++) {
            A[i] = postFixArrary[j];
        }
        return  A;
    }
}
