package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

//https://www.youtube.com/watch?v=bWLoPwf1bsM
public class SameReferenceClassLevelLockExample {

    public static synchronized void m1() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - SameReferenceObjectLevelLockExample.m1() - " + Thread.currentThread().getName());

    }

    public static synchronized void m2() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - SameReferenceObjectLevelLockExample.m2() - " + Thread.currentThread().getName());

    }

    public static void main(String[] args) {

        SameReferenceClassLevelLockExample sameReferenceObjectLevelLockExample = new SameReferenceClassLevelLockExample();
        Thread11 thread11 = new Thread11(sameReferenceObjectLevelLockExample);
        Thread22 thread22 = new Thread22(sameReferenceObjectLevelLockExample);
        thread11.start();
        thread22.start();
    }

}

class Thread11 extends Thread {

    private SameReferenceClassLevelLockExample object = null;

    public Thread11(SameReferenceClassLevelLockExample sameReferenceObjectLevelLockExample) {
        this.object = sameReferenceObjectLevelLockExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }
}

class Thread22 extends Thread {

    private SameReferenceClassLevelLockExample object = null;

    public Thread22(SameReferenceClassLevelLockExample sameReferenceObjectLevelLockExample) {
        this.object = sameReferenceObjectLevelLockExample;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }

}

