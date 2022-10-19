package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceCachedThreadPool {
    public static void main(String[] args) {
        // Create thread in thread pool only when no thread is free
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Integer i : IntStream.range(1, 101).toArray())
            executorService.execute(new Task());
        System.out.println("ExecutorServiceCachedThreadPool.main() - " + Thread.currentThread().getName());
    }
}
