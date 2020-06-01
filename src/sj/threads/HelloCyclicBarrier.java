package sj.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloCyclicBarrier {

    public static void main(String [] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(2);
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(()->{
            try {
                System.out.println("Child before the await call. Waiting: "+ cb.getNumberWaiting());
                cb.await();
                System.out.println("Child After the await call. Waiting: " + cb.getNumberWaiting());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(500);
        System.out.println("waiting cb count is : " + cb.getParties() + " waiting for " + cb.getNumberWaiting());

        Thread.sleep(1000);
        cb.await();
        System.out.println("main continues the processing : " + cb.getNumberWaiting());

        es.shutdown();

    }
    
    
}
