package sj.generics;

public class FIndMaxGenerics {

    public  <E extends  Comparable<E>>  E findMax(E a ,E b){

        int x = a.compareTo(b);
        if (x>0){
            return a;
        }else{
            return b;
        }
    }


    public static  void main(String[] args){

        FIndMaxGenerics hw = new FIndMaxGenerics();


        System.out.println( hw.findMax(1,2));
        System.out.println( hw.findMax(2.0,3.0));
        System.out.println( hw.findMax("abc","xyz"));
        System.out.println( hw.findMax('c','b'));

    }

}
