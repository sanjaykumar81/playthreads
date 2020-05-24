package sj.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerWaitNotify {

    public static void main(String[] args){
        Job job = new Job();

        Thread producer = new Thread(()->{
            try {
                job.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(()->{
            try {
                job.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}


class Job{
    private LinkedList<Integer> queue = new LinkedList<>();
    private final int QUEUE_SIZE=10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value =0;
        while(true) {
            synchronized (lock) {
                Thread.sleep(100);
                if(queue.size() < QUEUE_SIZE) {
                    queue.add(value++);
                    System.out.println("Producing .......queue size is : " + queue.size());
                }
                if(queue.size() == QUEUE_SIZE) {
                    System.out.println("going to wait now ");
                    lock.wait(); // Its important to note that you have to call the wait on the lock which used for synchronized block
                    System.out.println("someone send a notification:) ");
                }
            }
        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            synchronized (lock) {
                if(!queue.isEmpty()) {
                    int i = queue.removeFirst();

                    System.out.println("consuming ..... Got element : " + i + " Queue size is :" + queue.size());
                }else {
                    lock.notifyAll(); // Its important to note that you have to call the notify on the lock which used for synchronized block
                }

            }
        }
    }
}


