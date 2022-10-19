package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceSingleThreadedExecutor {

    public static void main(String[] args) {
        // Create only one thread in thread pool
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (Integer i : IntStream.range(1, 101).toArray())
            executorService.execute(new Task());
        System.out.println("ExecutorServiceSingleThreadedExecutor.main() - " + Thread.currentThread().getName());
    }

}
