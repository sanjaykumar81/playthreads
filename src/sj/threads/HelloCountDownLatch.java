package sj.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloCountDownLatch {

    public static void main(String [] args) throws InterruptedException {

//        CountDownLatch cdl = new CountDownLatch(5);
//        // pass this to threads to completed the task.
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        List<String> workers = Collections.synchronizedList(new LinkedList<>());
//        es.submit(new Worker(workers,"Ravi",cdl));
//        es.submit(new Worker(workers,"Krishan",cdl));
//        es.submit(new Worker(workers,"Sanjay",cdl));
//        es.submit(new Worker(workers,"Ajay",cdl));
//        es.submit(new Worker(workers,"Vijay",cdl));
//
//
//        cdl.wait();
//        workers.stream().forEach(name-> System.out.println(name));
//
//        System.out.println("Dish has prepared");
//        es.shutdown();

        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(new Worker(outputScraper, countDownLatch));
        es.submit(new Worker(outputScraper, countDownLatch));
        es.submit(new Worker(outputScraper, countDownLatch));
        es.submit(new Worker(outputScraper, countDownLatch));
        es.submit(new Worker(outputScraper, countDownLatch));

//        List<Thread> workers = Stream
//                .generate(() -> new Thread(new Worker(outputScraper, countDownLatch)))
//                .limit(5)
//                .collect(Collectors.toList());

//        workers.forEach(Thread::start);
        countDownLatch.await();
        outputScraper.add("Latch released");
        outputScraper.stream().forEach(x-> System.out.println(x));

    }
}

//class Worker implements Runnable {
//    private List<String> workList = new LinkedList<>();
//    private CountDownLatch cdl;
//    private  String workerName;
//
//    Worker(List<String> workList,String workerName, CountDownLatch cdl){
//        this.workList = workList;
//        this.cdl= cdl;
//        this.workerName = workerName;
//    }
//
//    public void run(){
//        System.out.println("working :" + this.workerName);
//        //dosomework();
//        workList.add(this.workerName);
//        cdl.countDown();
//
//    }
//}

class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
       // doSomeWork();
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}
