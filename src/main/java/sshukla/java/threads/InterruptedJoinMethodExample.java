package sshukla.java.threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class InterruptedJoinMethodExample extends Thread {
    static InterruptedSleepMethodExample interruptedSleepMethodExample1 = new InterruptedSleepMethodExample();
    static InterruptedSleepMethodExample interruptedSleepMethodExample2 = new InterruptedSleepMethodExample();

    @Override
    public void run() {
        for (int i : IntStream.range(1, 10).toArray()) {
            try {
                interruptedSleepMethodExample1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " - I am in MyExtendedThread.run() - " + LocalDateTime.now());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        interruptedSleepMethodExample1.setName("Thread-1");
        interruptedSleepMethodExample1.start();

        interruptedSleepMethodExample2.setName("Thread-2");
        interruptedSleepMethodExample2.start();

        for (int i : IntStream.range(1, 10).toArray()) {
            System.out.println(Thread.currentThread().getName() + " - I am in InterruptedYieldMethodExample.main() - " + LocalDateTime.now());
        }

    }

}
