package sj.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloCompletableFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

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
