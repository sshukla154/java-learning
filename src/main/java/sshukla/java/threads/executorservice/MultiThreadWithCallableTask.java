package sshukla.java.threads.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class MultiThreadWithCallableTask {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (Integer i : IntStream.range(1, 11).toArray()) {
            executorService.submit(new TaskWithCallableInterface());
        }
        System.out.println("MultiThreadWithCallableTask.main() - " + Thread.currentThread().getName());

        executorService.shutdown();
    }

}
