package sshukla.java.eight;

/**
 * @author 'Seemant Shukla' on '23/09/2022'
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 1. Consumer -> Bi-Consumer
 * 2. Predicate -> Bi-Predicate
 * 3. Function -> Bi-Function, Unary Operator, Binary Operator
 * 4. Supplier
 */
public class FIImplementedClassInterfacesExamples {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Step-1 : Simple approach
        numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

        System.out.println("===========================");

        //Step-2 : Expended approach of Step-1
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Consumer<Integer> println = System.out::println;

        numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(println);


        System.out.println("===========================");

        //Step-3 : Expended version of Step-2
        Predicate<Integer> isEvenPredicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction1 = new Function<>() {
            @Override
            public Integer apply(Integer integerInput) {
                return integerInput * integerInput;
            }
        };
        Consumer<Integer> println1 = new Consumer<>() {
            @Override
            public void accept(Integer integerInput) {
                System.out.println(integerInput);
            }
        };

        numbers.stream().filter(isEvenPredicate1).map(squareFunction1).forEach(println1);

    }

}
