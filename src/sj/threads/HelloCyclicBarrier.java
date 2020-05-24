package sj.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloCyclicBarrier {

    public static void main(String [] args){

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
        System.out.println("waiting cb count is : " + cb.getParties() + " waiting for " + cb.getNumberWaiting());
        //   cb.await();
        System.out.println("main continues the processing : " + cb.getNumberWaiting());

        es.shutdown();

    }
    
    
}
