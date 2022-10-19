package sshukla.java.threads.executorservice;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class MultiThread {

    public static void main(String[] args) {
        for (Integer i : IntStream.range(1, 11).toArray()) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
        System.out.println("ExecutorServiceFixedThreadPool.main() - " + Thread.currentThread().getName());
    }

}
