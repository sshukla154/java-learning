package sshukla.java.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class HashMapAndConcurrentHashMap extends Thread {

    /**
     * Will encounter `java.util.ConcurrentModificationException` when we use HashMap because from main thread we are reading the values and in between from child thread we started modifying the values
     * <p>
     * No error when we use ConcurrentHashMap()
     **/
//    static Map<Integer, String> hashMap = new HashMap<>();
    static Map<Integer, String> hashMap = new ConcurrentHashMap<>();

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("I am writing from child thread after 1000MS ===> ");
            hashMap.put(4, "D");
        } catch (InterruptedException exception) {
            System.out.println("I encountered InterruptedException !!!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        HashMapAndConcurrentHashMap hashMapAndConcurrentHashMap = new HashMapAndConcurrentHashMap();
        hashMapAndConcurrentHashMap.start();
        for (Integer i : hashMap.keySet()) {
            System.out.println("I am reading from main thread ===> " + i);
            Thread.sleep(10000);
        }

    }

}
