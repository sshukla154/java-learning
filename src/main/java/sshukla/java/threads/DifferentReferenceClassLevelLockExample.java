package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

//https://www.youtube.com/watch?v=bWLoPwf1bsM
public class DifferentReferenceClassLevelLockExample {

    public static synchronized void m1() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - DifferentReferenceClassLevelLockExample.m1() - " + Thread.currentThread().getName());
    }

    public static synchronized void m2() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - DifferentReferenceClassLevelLockExample.m2() - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread33 thread33 = new Thread33(new DifferentReferenceClassLevelLockExample());
        Thread44 thread44 = new Thread44(new DifferentReferenceClassLevelLockExample());
        thread33.start();
        thread44.start();
    }

}

class Thread33 extends Thread {

    DifferentReferenceClassLevelLockExample object;

    public Thread33(DifferentReferenceClassLevelLockExample object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }
}

class Thread44 extends Thread {

    DifferentReferenceClassLevelLockExample object;

    public Thread44(DifferentReferenceClassLevelLockExample object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }

}
