package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '12/10/2022'
 */
public class JavaYieldExample extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println(Thread.currentThread().getName() + " in control");
    }

    public static void main(String[] args) {
        JavaYieldExample t1 = new JavaYieldExample();
        JavaYieldExample t2 = new JavaYieldExample();
        // this will call run() method
        t1.start();
        t2.start();
        for (int i = 0; i < 3; i++) {
            // Control passes to child thread
            t1.yield();
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
}