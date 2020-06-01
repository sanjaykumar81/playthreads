package sj.collections;

import java.util.Comparator;
import java.util.TreeSet;

public class HelloTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zulu");
        treeSet.add("alpha");
        treeSet.add("tango");
        treeSet.add("delta");
        treeSet.add("zulu");
        treeSet.add("foxtrot");
        treeSet.add("mike");
        treeSet.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();



        treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add("zulu");
        treeSet.add("alpha");
        treeSet.add("tango");
        treeSet.add("delta");
        treeSet.add("zulu");
        treeSet.add("foxtrot");
        treeSet.add("mike");
        treeSet.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();

    }
}
