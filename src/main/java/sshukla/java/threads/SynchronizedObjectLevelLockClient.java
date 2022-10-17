package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedObjectLevelLockClient {

    /**
     * NOTE: In OBJECT LEVEL LOCK : Whenever multiple threads are operating on the same object then only synchronization play
     * the role. If multiple threads are operating on multiple objects then there is no impact of synchronization
     **/

    public static void main(String[] args) {

        /**
         * As we have only ONE Display object, so synchronized keyword work as per its functionality
         * i.e. we can except the output Dhoni 10 then Yuvraj 10 or Yuvraj 10 then Dhoni 10
         **/

        System.out.println("********************** SAME display OBJECT");
        Display_InstanceWish displayInstanceWish = new Display_InstanceWish();
        SynchronizedObjectLevelLockThread dhoniSynchronizedObjectLevelLockThread = new SynchronizedObjectLevelLockThread("Dhoni", displayInstanceWish);
        SynchronizedObjectLevelLockThread yuvrajSynchronizedObjectLevelLockThread = new SynchronizedObjectLevelLockThread("Yuvraj", displayInstanceWish);
        dhoniSynchronizedObjectLevelLockThread.start();
        yuvrajSynchronizedObjectLevelLockThread.start();

        System.out.println("********************** TWO DIFFERENT display OBJECTS");

        /**
         * As we have 2 different Display objects, so there won't be any impact of synchronized keyword
         * i.e. we cannot except the output
         **/

        Display_InstanceWish displayInstanceWish1 = new Display_InstanceWish();
        Display_InstanceWish displayInstanceWish2 = new Display_InstanceWish();
        SynchronizedObjectLevelLockThread supermanSynchronizedObjectLevelLockThread = new SynchronizedObjectLevelLockThread("Superman", displayInstanceWish1);
        SynchronizedObjectLevelLockThread batmanSynchronizedObjectLevelLockThread = new SynchronizedObjectLevelLockThread("Batman", displayInstanceWish2);
//        supermanSynchronizedThread.start();
//        batmanSynchronizedThread.start();


    }

}
