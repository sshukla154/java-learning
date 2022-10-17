package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedClassLevelLockClient {

    /**
     * NOTE: In CLASS LEVEL LOCK : Whenever multiple threads are operating on the same object or different object, synchronization play its role.
     * As STATIC method are called using class name i.e. there is no role of object in it. So, we need to have class level lock for execution of static synchronized method
     **/

    public static void main(String[] args) {

        System.out.println("********************** SAME display OBJECT");
        Display_StaticWish displayStaticWish = new Display_StaticWish();
        SynchronizedClassLevelLockThread dhoniSynchronizedClassLevelLockThread = new SynchronizedClassLevelLockThread("Dhoni", displayStaticWish);
        SynchronizedClassLevelLockThread yuvrajSynchronizedClassLevelLockThread = new SynchronizedClassLevelLockThread("Yuvraj", displayStaticWish);
        dhoniSynchronizedClassLevelLockThread.start();
        yuvrajSynchronizedClassLevelLockThread.start();

        System.out.println("********************** TWO DIFFERENT display OBJECTS");

        Display_StaticWish displayStaticWish1 = new Display_StaticWish();
        Display_StaticWish displayStaticWish2 = new Display_StaticWish();
        SynchronizedClassLevelLockThread supermanSynchronizedClassLevelLockThread = new SynchronizedClassLevelLockThread("Superman", displayStaticWish1);
        SynchronizedClassLevelLockThread batmanSynchronizedClassLevelLockThread = new SynchronizedClassLevelLockThread("Batman", displayStaticWish2);
        supermanSynchronizedClassLevelLockThread.start();
        batmanSynchronizedClassLevelLockThread.start();


    }

}
