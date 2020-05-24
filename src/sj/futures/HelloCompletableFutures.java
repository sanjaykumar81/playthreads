package sj.futures;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloCompletableFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> futureMsg = new CompletableFuture<>();
        futureMsg.complete("Welcome Home");

        Integer square= CompletableFuture.supplyAsync(()->{

            System.out.println("Thread is : "+ Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Random().nextInt(4);

        }).thenApply((x)->{

            System.out.println("Thread is : "+ Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x*x;
        }).thenApplyAsync((x)->{
            System.out.println("Thread is : "+ Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x*x;
        }).join();

        System.out.println("Square of number"+ square);

        System.out.println("Msg: "+ futureMsg.get());

        // CompletableFuture runs its tasks by default using Fork/Join pool
        // There is overloaded supplyAsync method that takes executor you pass  to use for execution.
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completable future supplyAsync has completed");
            return "Your future is bright";
        }).thenAccept((msg)-> System.out.println("Got a future msg: "+msg)).join(); //register a callback, called after future task completion

        System.out.println("completed running main");
    }
}
