package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceFixedThreadPoolForIOIntensiveTask {

    public static void main(String[] args) {
        // Create pool with 100 threads
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        //Submit the task for execution - 100 threads will be created and all the task will be executed
        for (Integer i : IntStream.range(1, 10001).toArray())
            executorService.execute(new IOIntensiveTask());
        System.out.println("ExecutorServiceFixedThreadPoolForIOIntensiveTask.main() - " + Thread.currentThread().getName());
    }

}
