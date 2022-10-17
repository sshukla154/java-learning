package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

//https://www.youtube.com/watch?v=bWLoPwf1bsM
public class SameReferenceObjectLevelLockExample {

    public synchronized void m1() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - SameReferenceObjectLevelLockExample.m1() - " + Thread.currentThread().getName());

    }

    public synchronized void m2() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - SameReferenceObjectLevelLockExample.m2() - " + Thread.currentThread().getName());

    }

    public static void main(String[] args) {

        SameReferenceObjectLevelLockExample sameReferenceObjectLevelLockExample = new SameReferenceObjectLevelLockExample();
        Thread0 thread0 = new Thread0(sameReferenceObjectLevelLockExample);
        Thread1 thread1 = new Thread1(sameReferenceObjectLevelLockExample);
        thread0.start();
        thread1.start();

    }

}

class Thread0 extends Thread {

    private SameReferenceObjectLevelLockExample object = null;

    public Thread0(SameReferenceObjectLevelLockExample sameReferenceObjectLevelLockExample) {
        this.object = sameReferenceObjectLevelLockExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }
}

class Thread1 extends Thread {

    private SameReferenceObjectLevelLockExample object = null;

    public Thread1(SameReferenceObjectLevelLockExample sameReferenceObjectLevelLockExample) {
        this.object = sameReferenceObjectLevelLockExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }

}
