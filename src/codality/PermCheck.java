package codality;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args){
     PermCheck check = new PermCheck();
        System.out.println("expect 1 got :"+ check.solution(new int[]{4,2,3,1}));
        System.out.println("expect 0 got :"+ check.solution(new int[]{4,3,1}));
        System.out.println("expect 0 got :"+ check.solution(new int[]{4}));
        System.out.println("expect 1 got :"+ check.solution(new int[]{1}));
    }

    public int solution(int[] A) {
        Set<Integer> permSet = new HashSet<>();

        for (int i :A) {

            if(permSet.contains(i)){
                return 0;
            }else{
                permSet.add(i);
            }

        }

        for (int i = 1; i < A.length+1; i++) {
            if(!permSet.contains(i)){
                return 0;
            }
        }

        return 1;
    }

}
