package sshukla.java.threads.executorservice;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class CpuIntensiveTask implements Runnable {
    @Override
    public void run() {
        for (Integer i : IntStream.range(1, 11).toArray())
            System.out.println(i + " : CpuIntensiveTask.run() - " + Thread.currentThread().getName());
    }
}
