package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '14/10/2022'
 */

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * Question: Threads T1, T2, T3 : Ensure T2 executes after T1, T3 executes after T2
 **/

public class EnsureThreadExecutionFlow extends Thread {

    @Override
    public void run() {
        for (Integer i : IntStream.range(1, 10).toArray())
            System.out.println(i + " : " + Thread.currentThread().getName() + " - I am in DaemonThreadExample.run() - " + LocalDateTime.now());
    }

    public static void main(String[] args) throws InterruptedException {
        EnsureThreadExecutionFlow t0 = new EnsureThreadExecutionFlow();
        t0.start();
        t0.join();
        EnsureThreadExecutionFlow t1 = new EnsureThreadExecutionFlow();
        t1.start();
        t1.join();
        EnsureThreadExecutionFlow t2 = new EnsureThreadExecutionFlow();
        t2.start();
        t2.join();
    }

}
