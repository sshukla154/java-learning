package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceFixedThreadPool {

    public static void main(String[] args) {
        // Create pool with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Submit the task for execution - Only 10 threads will be created and all the task will be executed
        for (Integer i : IntStream.range(1, 101).toArray())
            executorService.execute(new Task());
        System.out.println("ExecutorServiceFixedThreadPool.main() - " + Thread.currentThread().getName());
    }

}
