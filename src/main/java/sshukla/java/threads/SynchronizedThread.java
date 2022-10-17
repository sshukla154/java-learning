package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedThread extends Thread {

    private String name;
    private Display display;

    public SynchronizedThread(String name, Display display) {
        this.name = name;
        this.display = display;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -  SynchronizedThread.run()");
        display.wish(name);
    }
}
