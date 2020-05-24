package codality;

import org.junit.Assert;

public class MyFibonacci {

    public static void main(String [] args){
        MyFibonacci fibo = new MyFibonacci();
        int result = fibo.printFibo(9);
        Assert.assertEquals(34,result);
    }


    public int printFibo(int n){


        if (n<=1){
            //System.out.println(1);
            return n;
        }
        int x = printFibo(n-1);
        int y = printFibo( n-2);

        return x+y;
    }
    
}
