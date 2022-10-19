package sshukla.java.threads.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class ExecutorServiceScheduleThreadPool {
    public static void main(String[] args) {
        // For scheduling of tasks
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //Task to run after 10 seconds
        scheduledExecutorService.schedule(new Task(), 10, TimeUnit.SECONDS);

        // Wait for 15 seconds and then run task repeatedly every 10 seconds
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        // Wait for 15 seconds and then run task repeatedly every 10 seconds after previous task is completed
        scheduledExecutorService.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

        for (Integer i : IntStream.range(1, 101).toArray())
            scheduledExecutorService.execute(new Task());
        System.out.println("ExecutorServiceScheduleThreadPool.main() - " + Thread.currentThread().getName());
    }
}
