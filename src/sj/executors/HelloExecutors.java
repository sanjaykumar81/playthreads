package sj.executors;

import java.util.concurrent.*;

public class HelloExecutors {

    public static void main(String [] args){

        ExecutorService excutor = new ForkJoinPool();
        Executors.newWorkStealingPool(4);
        new ScheduledThreadPoolExecutor(5);

    }
}
