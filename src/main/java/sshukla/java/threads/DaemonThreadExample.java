package sshukla.java.threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '14/10/2022'
 */

/**
 * JVM wait for all the threads to be completed (Main thread and child thread) before exiting
 * but in case of daemon thread JVM does not wait to get it completed
 *
 * e.g. if daemonThreadExample.setDaemon(true); is enabled, possibly not all 100 times the sout will be printed
 * but if we disable/comment-out the setting of a thread to daemon then 100% all the sout will be printed.
 **/
public class DaemonThreadExample extends Thread {

    @Override
    public void run() {
        for (Integer i : IntStream.range(1, 100).toArray())
            System.out.println(i + "- " + Thread.currentThread().getName() + " - I am in DaemonThreadExample.run() - " + LocalDateTime.now());
    }

    public static void main(String[] args) {
        DaemonThreadExample daemonThreadExample = new DaemonThreadExample();
        daemonThreadExample.setDaemon(true);
//        daemonThreadExample.setName("Child-Thread");
        daemonThreadExample.start();
        daemonThreadExample.setName("Child-Thread");

        for (Integer i : IntStream.range(1, 10).toArray())
            System.out.println(i + "- " + Thread.currentThread().getName() + " - I am in MyExtendedThread.main() - " + LocalDateTime.now());
    }


}
