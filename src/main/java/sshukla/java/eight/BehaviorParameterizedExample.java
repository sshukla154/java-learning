package sshukla.java.eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author 'Seemant Shukla' on '23/09/2022'
 */
public class BehaviorParameterizedExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        /**Step-1*/
        //Getting all even
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        //Getting all odd
        numbers.stream().filter(x -> x % 2 != 0).forEach(System.out::println);


        /**Step-1 : Pulling out Even and Odd Predicate*/
        Consumer<Integer> PrintConsumer = System.out::println;

        //Getting all even and odd from Predicate
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Predicate<Integer> isOddPredicate = x -> x % 2 != 0;

        numbers.stream().filter(isEvenPredicate).forEach(PrintConsumer);

        numbers.stream().filter(isOddPredicate).forEach(PrintConsumer);

        /**Step-2 : Passing the behaviour (Even or Odd) as parameter*/
        filterAndPrint(numbers, x -> x % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);


    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicateCheck) {
        numbers.stream().filter(predicateCheck).forEach(System.out::println);
    }

}
