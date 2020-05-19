package codality;

public class FrogRiverOne {

    public static void main(String [] args){

        FrogRiverOne frogRiver = new FrogRiverOne();
        System.out.println(frogRiver.solution(5, new int[]{1,3,1,4,2,3,5,4}));
        assert  6 ==frogRiver.solution(5, new int[]{1,3,1,4,2,3,5,4});

    }

    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        if (X > A.length){
            return -1;
        }
        int [] path = new int[X+1];
        path[0] =1;
        int remainingLeaveTofall = X;
        for (int i = 0; i < A.length; i++) {
            int leafPosition = A[i];
            if(leafPosition >= path.length){
                continue;
            }
            if(path[leafPosition] == 0){
                path[leafPosition] = 1;
                remainingLeaveTofall = remainingLeaveTofall-1;
                if(remainingLeaveTofall ==0){
                    return i;
                }
            }
        }
        return -1;
    }
}
