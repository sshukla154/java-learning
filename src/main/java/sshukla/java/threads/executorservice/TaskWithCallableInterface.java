package sshukla.java.threads.executorservice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class TaskWithCallableInterface implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (Integer i : IntStream.range(1, 11).toArray()) {
            System.out.println(i + " : TaskWithCallableInterface.run() - " + Thread.currentThread().getName());
        }
        return new Random().nextInt();
    }
}
