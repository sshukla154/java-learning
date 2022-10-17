package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedObjectLevelLockThread extends Thread {

    private String name;
    private Display_InstanceWish displayInstanceWish;

    public SynchronizedObjectLevelLockThread(String name, Display_InstanceWish displayInstanceWish) {
        this.name = name;
        this.displayInstanceWish = displayInstanceWish;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -  SynchronizedThread.run()");
        displayInstanceWish.wish(name);
    }
}
