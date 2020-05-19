package sj.strings;


import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class HelloStrings {

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());
        aList.parallelStream().reduce(0L,Long::sum);

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool.submit(
                () -> aList.parallelStream().reduce(0L, Long::sum)).get();

        Long l = 500L;
        System.out.println(l.sum(10L, 20L));
        System.out.println(l);
        System.out.println(actualTotal);

//        assertEquals((lastNum + firstNum) * lastNum / 2, actualTotal);
    }
}
