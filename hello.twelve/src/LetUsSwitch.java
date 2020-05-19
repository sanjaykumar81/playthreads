import java.util.HashMap;

public class LetUsSwitch {
    public static void main(String[] args){

        Fruits fruit = Fruits.APPLE;
        TestFinalize tf = new TestFinalize();
        tf = null;
        System.gc();
        switch (fruit){
            case APPLE -> System.out.println("It's Apple");
            case GRAPE -> System.out.println("It's Grape");
            case BANANA -> System.out.println("It's Banana");
            default -> System.out.println("Not a fruit");
        }


    }



}

enum Fruits{
    GRAPE,
    APPLE,
    BANANA
}


class TestFinalize{

    @Override
    public void finalize() throws Throwable{

        System.out.println("In the finalize function .. Hurrar !!!");

    }
}