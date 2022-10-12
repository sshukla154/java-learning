package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class InterruptedJoinMethodExample extends Thread {

    @Override
    public void run() {
        try {
            for (int i : IntStream.range(1, 10).toArray()) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " - I am in MyExtendedThread.run()");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
