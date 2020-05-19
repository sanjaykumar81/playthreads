package sj.futures;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureThreadPools {

    public static void main(String[]args) throws Exception {

        CompletableFuture cf =  CompletableFuture.supplyAsync(()-> {return "My CF experiment";});

        CompletableFuture<String> cf1 = cf.thenApply(cf_result-> cf_result +" "+ 1);
        System.out.println( cf1.get());

//        Assert.that("My CF experiment 1".equals(cf1.get()), "thenApply returns a completable future");

        CompletableFuture cf2 = cf.thenAccept((msg)-> System.out.println(msg+ "2"));
        System.out.println(cf2.get());
//        Assert.that(null == cf2.get(), "Then accept return taken runnable and return void");
    }



}
