package sj.desingpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class HelloObserver {

    public static void main(String[] args){

    Subject subject = new Subject();
    subject.registerObserver(new ObserverImpl1("Sanjay"));
    subject.registerObserver(new ObserverImpl1("jay"));
    subject.registerObserver(new ObserverImpl1("ajay"));
    subject.registerObserver(new ObserverImpl1("Sjay"));
    subject.registerObserver(new ObserverImpl1("vijay"));
    subject.registerObserver(new ObserverImpl1("jaykumar"));
    subject.registerObserver(new ObserverImpl1("Santosh"));
    subject.registerObserver(new ObserverImpl1("Sanay"));
    subject.randomOperation();
    subject.randomOperation();
    subject.randomOperation();
    subject.randomOperation();
    subject.randomOperation();

    }
}

class Subject {
     List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    public void randomOperation(){

        if (ThreadLocalRandom.current().nextInt(100)%3 == 0){
            notifyObservers();
        }
    }

    private void notifyObservers(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(()->observers.stream().forEach(observer -> observer.execute()));
        executor.shutdown();

    }

}
 class ObserverImpl1 implements Observer {
    private String name;
    public ObserverImpl1(String name){
        this.name = name;
    }
    @Override
    public void execute() {
        System.out.println("Got notified: " + this.name);
    }
}


interface Observer {
    public void execute();
}