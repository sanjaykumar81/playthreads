package codality;

import java.util.Stack;

public class BinaryGap {
    public static void main(String [] args){

        BinaryGap gap = new BinaryGap();
        System.out.println("2 : "+gap.solution(2));
        System.out.println("5 : "+gap.solution(5));
        System.out.println("25856 : "+gap.solution(25856));
        System.out.println("1041 : "+gap.solution(1041));
        System.out.println("51712 : "+gap.solution(51712));
        System.out.println("2147483647 : "+gap.solution(2147483647));
    }

    public int solution(int N){

        String binaryString =  Integer.toBinaryString(N);

        char [] intChar = binaryString.toCharArray();

        int maxGap =0;
        int gap =0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < intChar.length; i++) {

            if (stack.empty() && intChar[i] == '0'){
                continue;
            }else if (stack.isEmpty()){
                stack.push(intChar[i]);
                continue;
            }
            if(stack.peek() == '1' && intChar[i] =='1'){
                continue;
            }
            if(stack.peek() == '1' && intChar[i] =='0'){
                stack.push('0');
                continue;
            }
            if(stack.peek() == '0' && intChar[i] =='0'){
                stack.push('0');
                continue;
            }
            if (stack.peek() == '0' && intChar[i] =='1'){
                gap = stack.size() -1;
                if(maxGap < gap){
                    maxGap = gap;
                }
                stack.clear();
                stack.push('1');
            }
        }
        return maxGap;
    }

}
