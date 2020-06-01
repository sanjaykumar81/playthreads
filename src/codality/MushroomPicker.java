package codality;

public class MushroomPicker {
    public static void main(String[] args) {

        MushroomPicker mp = new MushroomPicker();
        System.out.println(mp.maxMashroom(new int[]{2,3,7,5,1,3,9},4,6));
    }
    public int maxMashroom(int[] A, int k, int m) {
        int [] prefixSum = buildPrefixSums(A);

        return findMaxMashroom(prefixSum, A.length, k,m);
    }

    private int findMaxMashroom(int[] prefixSum,int length, int k, int m) {

        int leftMoveResult = calculateLeftMove(prefixSum, length, k,m);
        int rightMoveResult= calculateRightMove(prefixSum, length, k,m);
        return  leftMoveResult > rightMoveResult? leftMoveResult :rightMoveResult;
    }

    private int calculateLeftMove(int[] prefixSum, int length, int k, int m) {
        int result =0 ;
        for (int i = 0; i < Math.min(k,m) +1 ; i++) {

            int lef_position = k -i;
            int right_position = Math.min(length-1, Math.max(k, k+m -2*i));
            result = Math.max(result, count_total(prefixSum, lef_position, right_position));

        }
        return result;
    }

    private int count_total(int[] prefixSum, int lef_position, int right_position) {

        return prefixSum[right_position+1] - prefixSum[lef_position];
    }

    private int calculateRightMove(int[] prefixSum, int length, int k, int m) {
        int result =0 ;
        for (int i = 0; i < Math.min(m+1,length-k) ; i++) {

            int right_position = k +i;
            int lef_position = Math.max(0, Math.min(k, k-(m -2*i)));
            result = Math.max(result, count_total(prefixSum, lef_position, right_position));

        }
        return result;
    }

    private int[] buildPrefixSums(int[] A) {

        int [] prefixSum = new int[A.length +1];
        prefixSum[0] =0;
        for (int i = 1; i < A.length+1;  i++) {

            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }

        return prefixSum;
    }
}
