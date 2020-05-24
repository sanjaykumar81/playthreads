package sj.optional;

import java.util.Optional;

public class HelloOptional {

    public static void main(String [] args){
        Optional<Man> man = Optional.of(new Man("sanjay",34));
        man.ifPresent(m ->{ System.out.print(m.getName()); System.out.print(" " +m.getAge());});


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

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}