package sj.threads;

/**
 * This class is to demonstrate the use to runnable interface for concurrency.
 * Also, explore the concept of start(), join() and sleep()
 */
public class HelloThreads {

    public static void main(String [] args){

        TaskOne runnableOne = new TaskOne("one");
        Thread taskone = new Thread(runnableOne);
        TaskTwo runnableTwo = new TaskTwo("two");
        Thread tasktwo = new Thread(runnableTwo);
        taskone.start(); // starting thread one
        tasktwo.start(); // starting thread two

        try {
            /**
             * Without join() the main thread will run in concurrently with other two threads.
             * Try this by commenting line from 18 to 28 and noticing the output.
             */
            taskone.join(); // main thread is waiting for thread one to complete.
            tasktwo.join(); // main thread is waiting for thread two to complete
        } catch (InterruptedException e) {
            System.out.println("Interruption exception:"+ e);
        }


        System.out.println("Task one Status:" + runnableOne.getStatus());
        System.out.println("Task two Status:" + runnableTwo.getStatus());


    }

}


class TaskOne implements Runnable{

    private final String name;
    private String status = "NotCompleted";

    public TaskOne(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println("Started thread: "+ this.name + " at:" +System.currentTimeMillis());
            Thread.sleep((long) (Math.random()*5000));
            System.out.println("Completed thread: "+ this.name + " at:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " +e.getMessage());
        }

        this.status = "TaskOneCompleted";
    }

    public String getStatus() {
        return status;
    }
}
class TaskTwo implements Runnable{

    private final String name;
    private String status = "NotCompleted";

    public TaskTwo(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println("Started thread: "+ this.name + " at:" +System.currentTimeMillis());
            Thread.sleep((long) (Math.random()*5000));
            System.out.println("Completed thread: "+ this.name + " at:" +System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " +e.getMessage());
        }

        this.status = "TaskTwoCompleted";
    }

    public String getStatus() {
        return status;
    }
}

