package sshukla.java.threads.executorservice;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class SingleThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        System.out.println("ExecutorServiceFixedThreadPool.main() - " + Thread.currentThread().getName());
    }
}
