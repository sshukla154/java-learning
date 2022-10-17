package sshukla.java.threads;

import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class Display_InstanceWish {

    //public void wish(String input) {
    public synchronized void wish(String input) {
        for (Integer i : IntStream.range(1, 10).toArray()) {
            System.out.println(i + " - Good Morning: " + input);
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + " - Good Morning: " + input);
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
