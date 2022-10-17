package sshukla.java.threads;

import java.util.Vector;
import java.util.stream.IntStream;

import static sshukla.java.threads.ProducerConsumerExample.integerVector;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

// Using Synchronized method
public class ProducerConsumerExample {

    static Vector<Integer> integerVector = new Vector<>();

    public static void main(String[] args) {
        for (Integer i : IntStream.range(1, 10000).toArray()) {
            ProducerThread producerThread = new ProducerThread(i);
            producerThread.start();
            ConsumerThread consumerThread = new ConsumerThread();
            consumerThread.start();
        }
    }

}

class ProducerThread extends Thread {

    private final Integer inputNumber;

    public ProducerThread(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        System.out.println("Produced: " + inputNumber);
        produceToVector();
    }

    public synchronized void produceToVector() {
        if (integerVector.size() == 10) {
            try {
                System.out.println("Stack is full - wait() - " + Thread.currentThread().getName() + " - " + integerVector.size());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        integerVector.add(inputNumber);
        notifyAll();
    }
}

class ConsumerThread extends Thread {

    @Override
    public void run() {
        System.out.println("Consumed: " + consumeFromVector());
    }

    public synchronized Integer consumeFromVector() {
        if (integerVector.isEmpty()) {
            try {
                System.out.println("Stack is empty - wait() - " + Thread.currentThread().getName() + " - " + integerVector.size());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        integerVector.notifyAll();
        notifyAll();
        return integerVector.remove(0);
    }
}
