package sshukla.java.failfirstandfailsafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 'Seemant Shukla' on '10/10/2022'
 */
public class FailFirstAndFailSafeIterator {

    /**
     * Iterator provides transverse of collection of objects along with concurrent modification by adding, removing, updating the elements in that object. Internally Iterator uses a concept called ModCount, so any changes in ModCount Iterator throws ConcurrentModificationException.
     * <p>
     * FailFirst : While iterating when we perform modification of that same object we encounter `ConcurrentModificationException`. Some examples of Fail Fast iterator are iterator on ArrayList, HashMap collection classes.
     * FailSafe : While iterating when we perform modification of that same object if we don't encounter any `ConcurrentModificationException`, this is FailSafe Iterator as the modification is performed on copy of object installed of original object
     **/

    public static void main(String[] args) {

        failSafeExample();

        failFirstExample();

    }

    private static void failFirstExample() {
        //        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer i1 = iterator.next(); // At this point which throws error
            if (i1 == 3)
                integerList.add(4);
        }
        System.out.println(integerList);
    }

    private static void failSafeExample() {
        CopyOnWriteArrayList<Integer> integerCopyOnWriteArrayList = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3, 4});
        Iterator<Integer> iterator1 = integerCopyOnWriteArrayList.iterator();
        while (iterator1.hasNext()) {
            Integer i1 = iterator1.next();
            if (i1 == 4)
                integerCopyOnWriteArrayList.add(5);
        }
        System.out.println(integerCopyOnWriteArrayList);
    }

}
