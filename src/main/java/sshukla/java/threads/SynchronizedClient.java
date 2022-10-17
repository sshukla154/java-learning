package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class SynchronizedClient {

    /**
     * NOTE: Whenever multiple threads are operating on the same object then only synchronization play
     * the role. If multiple threads are operating on multiple objects then there is no impact of synchronization
     **/

    public static void main(String[] args) {

        /**
         * As we have only ONE Display object, so synchronized keyword work as per its functionality
         * i.e. we can except the output Dhoni 10 then Yuvraj 10 or Yuvraj 10 then Dhoni 10
         **/

        System.out.println("********************** SAME display OBJECT");
        Display display = new Display();
        SynchronizedThread dhoniSynchronizedThread = new SynchronizedThread("Dhoni", display);
        SynchronizedThread yuvrajSynchronizedThread = new SynchronizedThread("Yuvraj", display);
        dhoniSynchronizedThread.start();
        yuvrajSynchronizedThread.start();

        System.out.println("********************** TWO DIFFERENT display OBJECTS");

        /**
         * As we have 2 different Display objects, so there won't be any impact of synchronized keyword
         * i.e. we cannot except the output
         **/

        Display display1 = new Display();
        Display display2 = new Display();
        SynchronizedThread supermanSynchronizedThread = new SynchronizedThread("Superman", display1);
        SynchronizedThread batmanSynchronizedThread = new SynchronizedThread("Batman", display2);
//        supermanSynchronizedThread.start();
//        batmanSynchronizedThread.start();


    }

}
