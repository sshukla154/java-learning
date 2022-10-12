package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class InterruptedYieldMethodExample extends Thread {

    @Override
    public void run() {
        for (int i : IntStream.range(1, 10).toArray()) {
            System.out.println(Thread.currentThread().getName() + " - I am in InterruptedYieldMethodExample.run()");
        }
    }

    public static void main(String[] args) {

        InterruptedYieldMethodExample interruptedYieldMethodExample1 = new InterruptedYieldMethodExample();
        interruptedYieldMethodExample1.setName("Thread-1");
        interruptedYieldMethodExample1.start();

        InterruptedYieldMethodExample interruptedYieldMethodExample2 = new InterruptedYieldMethodExample();
        interruptedYieldMethodExample2.setName("Thread-2");
        interruptedYieldMethodExample2.start();
        for (int i : IntStream.range(1, 10).toArray()) {
            System.out.println(Thread.currentThread().getName() + " - I am in InterruptedYieldMethodExample.main()");
            interruptedYieldMethodExample1.yield();
            interruptedYieldMethodExample2.yield();
        }

    }

}
