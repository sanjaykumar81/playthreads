package codality;

import java.util.Arrays;
import java.util.stream.Stream;

public class Siblings {
    public static void main(String[] args){
        Siblings sb = new Siblings();
        int result = sb.solution(213);
        System.out.println("expected 321 and result is :" +result);


        result = sb.solution(553);
        System.out.println("expected 553 and result is :" +result);


        result = sb.solution(0);
        System.out.println("expected 0 and result is :" +result);

        result = sb.solution(10000);
        System.out.println("expected 10000 and result is :" +result);

        result = sb.solution(111);
        System.out.println("expected 111 and result is :" +result);
    }

    public int solution(int N) {

        String number = ""+N;
        char[] numbersEleArr = number.toCharArray();
        if(numbersEleArr.length==1){
            return N;
        }
        Arrays.sort(numbersEleArr);

        String maxNumber ="";
        for (int i = numbersEleArr.length-1; i >=0 ; i--) {
            maxNumber = maxNumber + numbersEleArr[i];
        }
        return  Integer.valueOf(maxNumber);
    }
}
