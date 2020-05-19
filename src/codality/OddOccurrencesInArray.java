package codality;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OddOccurrencesInArray {

    public static void main(String[] args){

        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int[] arr = new int[]{9,3,9,3,9,7,9};
        assert 7 == oddOccurrencesInArray.solution(arr);

    }

    public int solution(int[] A) {

        Set<Integer> resultSet = new HashSet<>();
        for (int i: A) {
            if(resultSet.contains(i)){
                resultSet.remove(i);
            }else{
                resultSet.add(i);
            }
        }


        return resultSet.iterator().next();
    }
}
