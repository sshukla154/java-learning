package sshukla.java.threads.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */

//https://www.youtube.com/watch?v=NEZ2ASoP_nY&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=8
public class MultiThreadWithCallableTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Create a Thread Pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<Integer>> futureList = new ArrayList<>();

        // Submit the tasks for execution and accept the placeholder object for return value
        for (Integer i : IntStream.range(1, 11).toArray()) {
            Future<Integer> future = executorService.submit(new TaskWithCallableInterface());
            futureList.add(future);
        }

        // Perform some unrelated operations - E.G. Preparing a list of integers
        List<Integer> integerList = Arrays.stream(IntStream.range(1, 11).toArray()).boxed().toList();

        for (Future<Integer> future : futureList) {
            Integer futureValue = future.get();// This is a blocking operation until future is ready to return a value
            System.out.println(futureValue + " - MultiThreadWithCallableTask.main() - " + Thread.currentThread().getName());
        }

        executorService.shutdown();
    }

}
