package sshukla.java.threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class InterruptedSleepMethodExample extends Thread {

    @Override
    public void run() {
        try {
            for (int i : IntStream.range(1, 10).toArray()) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " - I am in MyExtendedThread.run() - " + LocalDateTime.now());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        InterruptedSleepMethodExample interruptedSleepMethodExample1 = new InterruptedSleepMethodExample();
        interruptedSleepMethodExample1.setName("Thread-1");
        interruptedSleepMethodExample1.start();

        InterruptedSleepMethodExample interruptedSleepMethodExample2 = new InterruptedSleepMethodExample();
        interruptedSleepMethodExample2.setName("Thread-2");
        interruptedSleepMethodExample2.start();
        for (int i : IntStream.range(1, 10).toArray()) {
//            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " - I am in InterruptedYieldMethodExample.main() - " + LocalDateTime.now());
        }

    }

}
