package sshukla.java.eight;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
@Slf4j
public class Java8FeatureWithInteger {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(54, 23, 1223, 879, 12, 54, 98, 12, 23, 555, 1231, 8, 1223, 100, 11);

        printAllNumbersUsingMethodReference(numbers);

        printAllNumbersUsingLambdaExpression(numbers);

        printAllEvenNumbersUsingLambdaExpression(numbers);

    }

    private static void printAllEvenNumbersUsingLambdaExpression(List<Integer> numbers) {
        System.out.println("printAllEvenNumbersUsingLambdaExpression");
        numbers.stream().filter(Java8FeatureWithInteger::isNumberEven).forEach(Java8FeatureWithInteger::getIntegerConsumer);
    }

    public static void printAllNumbersUsingLambdaExpression(List<Integer> numbers) {
        System.out.println("printAllNumbersUsingLambdaExpression");
        numbers.stream().forEach(System.out::println);
    }

    public static void printAllNumbersUsingMethodReference(List<Integer> numbers) {
        System.out.println("\n" + "printAllNumbersUsingMethodReference");
        numbers.stream().forEach(Java8FeatureWithInteger::getIntegerConsumer);
    }

    private static void getIntegerConsumer(Integer x) {
        System.out.println(x);
    }

    private static Boolean isNumberEven(Integer x) {
        return x % 2 == 0;
    }

}
