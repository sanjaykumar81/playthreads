package sj.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class HelloStream {

    public static  void main(String[] args){

        List<Integer> intList = IntStream.range(1,100).boxed().collect(Collectors.toList());
        for (Integer i : intList) {
            System.out.println(i);
        }
        System.out.println();

        List<String> names = new LinkedList<>();
        names.add("Sanjay");
        names.add("njay");
        names.add("Sajay");
        names.add("ajay");
        names.add("a123jay");
        HelloStream.printNonAlphaNumericNames(names);
        HelloStream.printUpperCase(names);
        HelloStream.printConcatenatedNames(names);
        HelloStream.flatMapExample();
        HelloStream.rangeAndRangeClosed();
        HelloStream.streamClass();

    }

    public static void printNonAlphaNumericNames(List<String> names){
        List<String> filteredNames = names.parallelStream().filter(name-> name.matches("Sanjay")).collect(Collectors.toList());
        filteredNames.stream().forEach(name-> System.out.println(name));
    }

    public static void printUpperCase(List<String> names){
        List<String> filteredNames = names.parallelStream().map(name-> name.toUpperCase()).collect(Collectors.toList());
       filteredNames.stream().forEach(name-> System.out.println(name));
    }

    public static void printConcatenatedNames(List<String> names){

       String concatenatedNames = names.parallelStream().map(name-> name.toUpperCase()).reduce("",(a,b)->a+b);
       Optional<String> optionalNames = names.parallelStream().map(name-> name.toUpperCase()).reduce((a, b)->a+b);
        System.out.println(concatenatedNames);
        optionalNames.ifPresent(x->System.out.println(x));

    }

    public static void flatMapExample(){

        List<List<String>> personHobbies = new LinkedList<>();

        List<String> hobbies = new LinkedList<>();
        hobbies.add("Hockey");
        hobbies.add("Cricket");
        hobbies.add("Football");
        personHobbies.add(hobbies);
        hobbies = new LinkedList<>();
        hobbies.add("Swimming");
        hobbies.add("Running");
        hobbies.add("Kite flying");
        personHobbies.add(hobbies);
        hobbies = new LinkedList<>();
        hobbies.add("Singing");
        hobbies.add("Acting");
        hobbies.add("Reading");
        personHobbies.add(hobbies);

        List<String> allHobbies = personHobbies.stream().flatMap(hobb-> hobb.stream()).collect(Collectors.toList());

        allHobbies.stream().forEach(x-> System.out.println(x));

    }

    public static void rangeAndRangeClosed(){
        IntStream.range(1,10).forEach(x-> System.out.print(x + " "));
        System.out.println();
        IntStream.rangeClosed(1,10).forEach(x-> System.out.print(x + " "));
        System.out.println();
    }

    public static void streamClass(){
        Stream.iterate(0, x -> x+2).limit(10).forEach(x-> System.out.print(x+" "));
        System.out.println();
        Stream.generate(Math::random).limit(10).forEach(x-> System.out.print(x+" "));
        System.out.println();
    }


}