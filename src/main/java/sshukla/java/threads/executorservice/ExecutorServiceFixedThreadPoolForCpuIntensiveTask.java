package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceFixedThreadPoolForCpuIntensiveTask {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        //Submit the task for execution
        for (Integer i : IntStream.range(1, 1001).toArray())
            executorService.execute(new Task());
        System.out.println("ExecutorServiceFixedThreadPoolForCpuIntensiveTask.main() - " + Thread.currentThread().getName());
        executorService.shutdown();
    }

}
