package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedClassLevelLockThread extends Thread {

    private String name;
    private Display_StaticWish displayStaticWish;

    public SynchronizedClassLevelLockThread(String name, Display_StaticWish displayStaticWish) {
        this.name = name;
        this.displayStaticWish = displayStaticWish;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -  SynchronizedThread.run()");
        Display_StaticWish.wish(name);
    }
}
