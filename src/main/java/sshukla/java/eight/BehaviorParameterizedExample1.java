package sshukla.java.eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '23/09/2022'
 */
public class BehaviorParameterizedExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("Step-1");
        Collector<Integer, ?, List<Integer>> integerListCollector = Collectors.toList();
        System.out.println(numbers.stream().map(x -> x * x).collect(integerListCollector));
        System.out.println(numbers.stream().map(x -> x * x * x).collect(integerListCollector));
        System.out.println(numbers.stream().map(x -> x * x * x * x).collect(integerListCollector));


        System.out.println("Step-2 : Pulling out Even and Odd Predicate");
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> cubeFunction = x -> x * x * x;
        Function<Integer, Integer> quardFunction = x -> x * x * x * x;

        System.out.println(numbers.stream().map(squareFunction).collect(integerListCollector));
        System.out.println(numbers.stream().map(cubeFunction).collect(integerListCollector));
        System.out.println(numbers.stream().map(quardFunction).collect(integerListCollector));

        System.out.println("Step-3 : Passing the behaviour (Even or Odd) as parameter");
        System.out.println(mapAndCreateNewList(numbers, x -> x * x, integerListCollector));
        System.out.println(mapAndCreateNewList(numbers, x -> x * x * x, integerListCollector));
        System.out.println(mapAndCreateNewList(numbers, x -> x * x * x * x, integerListCollector));
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mapper, Collector<Integer, ?, List<Integer>> integerListCollector) {
        return numbers.stream().map(mapper).collect(integerListCollector);
    }

}
