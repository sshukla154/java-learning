package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

/**
 * ObjectLevelLock - When a Thread is executing synchronized method no other threads are allowed to execute any synchronized method
 * but other threads can execute non-synchronized methods.
 *
 * ClassLevelLock - When a Thread is executing static synchronized method no other threads are allowed to execute any static synchronized method
 * but other threads can execute non-synchronized methods (static or instance) and synchronized instance method.
 */
public class ThreadLockingWithSameObjectExample {

    public void m1() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - ThreadLockingExample.m1() - " + Thread.currentThread().getName());
    }

    public static void m2() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - ThreadLockingExample.m2() - " + Thread.currentThread().getName());
    }

    public synchronized void m3() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - ThreadLockingExample.m3() - " + Thread.currentThread().getName());
    }

    public synchronized static void m4() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - ThreadLockingExample.m4() - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadLockingWithSameObjectExample threadLockingWithSameObjectExample = new ThreadLockingWithSameObjectExample();
        Thread111 thread111 = new Thread111(threadLockingWithSameObjectExample);
        Thread222 thread222 = new Thread222(threadLockingWithSameObjectExample);
        thread111.start();
        thread222.start();
    }

}

class Thread111 extends Thread {

    private ThreadLockingWithSameObjectExample object;

    Thread111(ThreadLockingWithSameObjectExample threadLockingWithSameObjectExample) {
        this.object = threadLockingWithSameObjectExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
        object.m3();
        object.m4();
    }
}

class Thread222 extends Thread {

    private ThreadLockingWithSameObjectExample object;

    Thread222(ThreadLockingWithSameObjectExample threadLockingWithSameObjectExample) {
        this.object = threadLockingWithSameObjectExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
        object.m3();
        object.m4();
    }
}
