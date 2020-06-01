package sj.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UnmodifiableCollections {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Sanjay");
        names.add("Sanj");
        names.add("Saay");
        names.add("njay");
        names.add("Saay");
        names.stream().forEach(x-> System.out.print(x + " " ));
        System.out.println();
        List<String> unModifiable = Collections.unmodifiableList(names);
        try {
            unModifiable.add("vijay");
            unModifiable.stream().forEach(x-> System.out.print(x + " "));
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
