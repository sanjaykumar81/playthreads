package codality;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String [] args){

        MissingInteger mi = new MissingInteger();

       int result = mi.solution(new int[]{1, 3, 6, 4, 1, 2 });
        System.out.println("Expected 5: got : "+ result);
        result = mi.solution(new int[]{1, 3, 2 });
        System.out.println("Expected 4: got : "+ result);
        result = mi.solution(new int[]{-1, -3 });
        System.out.println("Expected 1: got : "+ result);
    }

    public int solution(int[] A) {

        Set<Integer> elements = new HashSet<>();
        for (int i : A) {
            if (i>0){
                elements.add(i);
            }
        }
        if(elements.isEmpty()){
            return 1;
        }
        elements.size();
        for (int i = 1; i <elements.size()+1; i++) {
            if(!elements.contains(i)){
                return i;
            }
        }

        return elements.size()+1;
    }
}
