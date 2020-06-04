package sj.java9flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloFlow {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        Flow.Subscriber subscriber = new Client();
        publisher.subscribe(subscriber);

        Stream.of("Welcome","Hi","Hello","RamRam","JaiSiaRam","Sayonara","Bye","Pranaam").forEach(publisher::submit);

        publisher.close();

        publisher = new SubmissionPublisher<>();

        Transformer<String, String> transformer = new Transformer<>(String::toUpperCase);
        publisher.subscribe(transformer);
        subscriber = new Client();
        transformer.subscribe(subscriber); // NOTE: attaching subscriber to transformer

        Stream.of("Welcome","Hi","Hello","RamRam","JaiSiaRam","Sayonara","Bye","Pranaam").forEach(publisher::submit);


        Thread.sleep(1000);

    }
}

class Client implements Flow.Subscriber<String>{
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Thread name is: "+Thread.currentThread().getName()+" Got item: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Publisher id done publishing");
    }
}

class Transformer<T,R> extends SubmissionPublisher<R> implements Flow.Processor<T,R> {

    private final Function<T, R> function;
    private Flow.Subscriber<? super R> subscriber;
    private Flow.Subscription subscription;

    public Transformer(Function<T,R> function){
        this.function = function;
    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
    }

    @Override
    public void onNext(T item) {
            submit(function.apply(item));
            subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();

    }

    @Override
    public void onComplete() {
        System.out.println("Done transforming !!");
        close();

    }
}