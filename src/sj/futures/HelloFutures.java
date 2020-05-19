package sj.futures;

import java.util.concurrent.*;

public class HelloFutures {

    public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {

        Callable taskOne = new TaskOne();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> futureReply =  executorService.submit(taskOne);

        // isDone() can be used when we are not sure about the time
//        while(true){
//            if (futureReply.isDone() == true){
//                break;
//            }
//            Thread.sleep(500);
//        }

        System.out.println(futureReply.get(6,TimeUnit.SECONDS)); // main thread will be blocked waiting for the furtureReploy
        executorService.shutdown();
    }
}

class TaskOne implements Callable<String>{

    @Override
    public String call() throws Exception {

        Thread.sleep(5000);
        return "Message from the callable";
    }
}