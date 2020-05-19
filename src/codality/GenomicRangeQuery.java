package codality;

import java.util.Arrays;

public class GenomicRangeQuery {
    public static void main(String []args){
        GenomicRangeQuery rangeQuery = new GenomicRangeQuery();
        int [] result = rangeQuery.solution("CAGCCTA",new int[]{2,5,0}, new int[]{4,5,6});

        System.out.print("expected output [2,4,1 ] and got : ");
        System.out.print("[");
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        System.out.println("]");

        result = rangeQuery.solution("CAGCCTA",new int[]{0}, new int[]{0});
        System.out.print("expected output [2] and got : ");
        System.out.print("[");
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        System.out.println("]");

        result = rangeQuery.solution("C",new int[]{0}, new int[]{0});
        System.out.print("expected output [2] and got : ");
        System.out.print("[");
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        System.out.println("]");

        result = rangeQuery.solution("CAAAAAAAAAAAAAB",new int[]{0,1}, new int[]{0,6});
        System.out.print("expected output [2,1] and got : ");
        System.out.print("[");
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        System.out.println("]");

        result = rangeQuery.solution("GTAAACCCGGGTTTAACCGGTTAACCGGTT",new int[]{0}, new int[]{0});
        System.out.print("expected output [3] and got : ");
        System.out.print("[");
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        System.out.println("]");


    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        char [] genome = S.toCharArray();
        int [] sol = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            int from = P[i];
            int to = Q[i];

            int minimumLF =0;
            for (int j = from; j <=to; j++) {
                char g = genome[j];

                if(g=='A'){
                    minimumLF =1;
                    break;
                }else if(g=='C'){
                    if (minimumLF ==0 ){
                        minimumLF = 2;
                    }else if(minimumLF >2){
                        minimumLF = 2;
                    }

                }else if(g=='G'){
                    if (minimumLF ==0 ){
                        minimumLF = 3;
                    }else if (minimumLF >3){
                        minimumLF = 3;
                    }

                }else if(g=='T'){
                    if (minimumLF ==0 ){
                        minimumLF = 4;
                    }
                }
            }

            sol[i] = minimumLF;
        }
        return sol;
    }

}
