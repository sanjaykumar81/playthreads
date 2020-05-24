package sj.threads;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerSemaphore {

    private static LinkedList<Integer> queue = new LinkedList<>();
   private static Semaphore lock = new Semaphore(1);

    public static void main(String[] args){

        Thread producer = new Thread(()->{
            while (true) {

                try {
                    lock.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (queue.size() <= 5) {
                    int  value = ThreadLocalRandom.current().nextInt(50,500);
                    System.out.println("Producing value : "+ value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.addLast(value);
                    System.out.println("Producer Queue size is : "+ queue.size());
                }
                lock.release();
            }
        });

        Thread consumer = new Thread(()->{

            while(true){
                try {
                    lock.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!queue.isEmpty()){
                    System.out.println("consumed : "+ queue.getFirst());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.removeFirst();
                    System.out.println("Consumer Queue size is :" + queue.size());
                }
                lock.release();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
