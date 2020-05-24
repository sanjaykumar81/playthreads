package sj.threads;

import java.util.concurrent.*;

public class CallableThreads {

    public static void main(String [] args){

        Callable<Long> c = new Callable<>() {
            @Override
            public Long call() throws Exception {
                long start = System.currentTimeMillis();
                Thread.sleep( ThreadLocalRandom.current().nextInt(1000,2000));
                long end = System.currentTimeMillis();

                return end-start;

            }
        };

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Long> duration = es.submit(c);
        Future<Long> duration1 = es.submit(c);
        Future<Long> duration2 = es.submit(c);
        Future<Long> duration3 = es.submit(c);

        try{
            System.out.println( "Duration of thread 0 execution is :"+ duration.get());
            System.out.println( "Duration of thread 1 execution is :"+ duration1.get());
            System.out.println( "Duration of thread 2 execution is :"+ duration2.get());
            System.out.println( "Duration of thread 3 execution is :"+ duration3.get());
        }catch (Exception e ){
            System.out.println("Exception :" + e.getMessage());
        }
        es.shutdown();
    }
}
