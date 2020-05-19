package codality;

import java.util.Arrays;

public class WidestVerticalPath {
    public static void main(String[] args){
        WidestVerticalPath verticalPath = new WidestVerticalPath();

        int result = verticalPath.solution(new int[]{1,8,7,3,4,1,8}, new int[]{6,4,1,8,5,1,7});
        System.out.println("expected 3 and result : "+result);

        result = verticalPath.solution(new int[]{5,5,5,7,7,7}, new int[]{3,4,5,1,3,7});
        System.out.println("expected 2 and result : "+result);

        result = verticalPath.solution(new int[]{6,10,1,4,3}, new int[]{2,5,3,1,6});
        System.out.println("expected 4 and result : "+result);


        result = verticalPath.solution(new int[]{4,1,5,4}, new int[]{4,5,1,3});
        System.out.println("expected 3 and result : "+result);

        result = verticalPath.solution(new int[]{0,1}, new int[]{0,1});
        System.out.println("expected 1 and result : "+result);

    }

    public int solution(int[] X, int[] Y) {
        // write your code in Java SE 8

        Arrays.sort(X);
        int maxWidth =0;
        for (int i = 0; i < X.length-1 ; i++) {

            int width = X[i+1]-X[i];
            if (width > maxWidth){

                maxWidth = width;
            }
        }

        return maxWidth;
    }
}
