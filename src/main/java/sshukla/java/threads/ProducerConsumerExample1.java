package sshukla.java.threads;

import java.util.Stack;
import java.util.stream.IntStream;

import static sshukla.java.threads.ProducerConsumerExample1.integerStack;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

//using Synchronized block
public class ProducerConsumerExample1 {

    static final Stack<Integer> integerStack = new Stack<>();

    public static void main(String[] args) {
        for (Integer i : IntStream.range(1, 100000).toArray()) {
            ProducerThread1 producerThread1 = new ProducerThread1(i);
            producerThread1.start();
            ConsumerThread1 consumerThread1 = new ConsumerThread1();
            consumerThread1.start();
        }
    }

}

class ProducerThread1 extends Thread {

    private final Integer inputNumber;

    public ProducerThread1(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        System.out.println("Produced: " + inputNumber);
        produceToStack();
    }

    private void produceToStack() {
        if (integerStack.size() == 10) {
            try {
                System.out.println("I am full - now wait()");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (integerStack) {
            integerStack.push(inputNumber);
            integerStack.notifyAll();
        }
    }
}

class ConsumerThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Consumed: " + consumeFromStack());
    }

    private Integer consumeFromStack() {
        if (integerStack.isEmpty()) {
            try {
                System.out.println("I am empty - now wait()");
                synchronized (integerStack) {
                    integerStack.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (integerStack) {
            integerStack.notifyAll();
            return integerStack.remove(0);
        }
    }
}
