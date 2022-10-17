package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */

//https://www.youtube.com/watch?v=bWLoPwf1bsM
public class DifferentReferenceObjectLevelLockExample {

    public synchronized void m1() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - DifferentReferenceObjectLevelLockExample.m1() - " + Thread.currentThread().getName());
    }

    public synchronized void m2() {
        for (Integer i : IntStream.range(0, 5).toArray())
            System.out.println(i + " - DifferentReferenceObjectLevelLockExample.m2() - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3(new DifferentReferenceObjectLevelLockExample());
        Thread4 thread4 = new Thread4(new DifferentReferenceObjectLevelLockExample());
        thread3.start();
        thread4.start();
    }

}

class Thread3 extends Thread {

    DifferentReferenceObjectLevelLockExample object;

    public Thread3(DifferentReferenceObjectLevelLockExample object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }
}

class Thread4 extends Thread {

    DifferentReferenceObjectLevelLockExample object;

    public Thread4(DifferentReferenceObjectLevelLockExample object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.m1();
        object.m2();
    }

}
