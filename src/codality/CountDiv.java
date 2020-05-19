package codality;

public class CountDiv {
    public static void main(String[] args){
        CountDiv countDiv = new CountDiv();
        int result = countDiv.solution(6,11,2);
        System.out.println("Expected 3 got :" +result);

        result = countDiv.solution(0,0,2);
        System.out.println("Expected 1 got :" +result);

        result = countDiv.solution(10,10,2);
        System.out.println("Expected 1 got :" +result);

        result = countDiv.solution(6,11,12);
        System.out.println("Expected 0 got :" +result);

        result = countDiv.solution(0,Integer.MAX_VALUE,Integer.MAX_VALUE);
        System.out.println("Expected 2 got :" +result);

        result = countDiv.solution(0,Integer.MAX_VALUE,1);
        System.out.println("max int : " + Integer.MAX_VALUE);
        System.out.println("Expected "+ (Integer.MAX_VALUE+1) +" got :" +result);

    }
    public int solution(int A, int B, int K){
        int count =0;
        int reminder = A%K;
        int sum = 0;

        if (reminder ==0 && A ==0){

            count++;
            if (A == B){
                return count;
            }

            sum = A;

        }else if(reminder ==0 && A !=0){

            count++;
            if (A == B){
                return count;
            }
            sum = A;
        }else{
            if(A==B){
                return 0;
            }
            sum = A- reminder;
        }

        count = count + (B-sum)/K;

        return count; //as in the while loop it is incremented 1 more than expected.
    }

}
