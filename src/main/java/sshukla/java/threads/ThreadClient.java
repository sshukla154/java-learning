package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class ThreadClient {

    public static void main(String[] args) throws InterruptedException {

        MyExtendedThread myExtendedThread1 = new MyExtendedThread();
        MyExtendedThread myExtendedThread2 = new MyExtendedThread();
        myExtendedThread1.start();
        myExtendedThread2.start();
        for (int i : IntStream.range(1, 10).toArray()) {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " - MyExtendedThread - ThreadClient.main()");
        }


        MyImplementedThread myImplementedThread1 = new MyImplementedThread();
        new Thread(myImplementedThread1).start();
        new Thread(myImplementedThread1).start();
        for (int i : IntStream.range(1, 10).toArray()) {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " - MyImplementedThread - ThreadClient.main()");
        }
    }

}
