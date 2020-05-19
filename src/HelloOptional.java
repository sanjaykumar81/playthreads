import java.util.Optional;

public class HelloOptional {

    public static void main(String [] args){
        Optional man = Optional.empty();


    }

}

class Man{
    private String name;
    private int age;
    public Man(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void printMsg(){
        System.out.println("Hi {binary gap }");
    }
}