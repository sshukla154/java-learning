package sshukla.java.eight;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
@Slf4j
public class Java8FeatureWithInteger {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(54, 23, 1223, 879, 12, 54, 98, 12, 23, 555, 1231, 8, 1223, 100, 11);

        printAllNumbersUsingMethodReference(numbers);

        printAllNumbersUsingLambdaExpression(numbers);

        printAllEvenNumbers(numbers);

        printAllOddNumbers(numbers);

        printSquaresOfEachNumbers(numbers);

        printSquaresOfAllEvenNumbers(numbers);

        printCubesOfAllOddNumbers(numbers);

        addNumbersToList(numbers);

        sumAllNumbersOfTheList(numbers); // stream(), reduce()

        reduceNumbersOfTheListToFirstParam(numbers); // stream(), reduce()

        reduceNumbersOfTheListToSecondParam(numbers); // stream(), reduce()

        reduceNumbersOfTheListToFindMaximum(numbers); // stream(), reduce()

        reduceNumbersOfTheListToFindMinimum(numbers); // stream(), reduce()

        sumOfSquaresOfEachNumbersInList(numbers); // stream(), map(), reduce()

        sumOfCubesOfEachNumbersInList(numbers); // stream(), map(), reduce()

        sumOfOddNumbers(numbers); // stream(), filter(), reduce()

        sumOfEvenNumbers(numbers); // stream(), filter(), reduce()

        distinctNumberFromList(numbers); //stream(), distinct(), forEach()

        distinctSortedNumberFromList(numbers); //stream(), distinct(), sorted(), forEach()

    }

    private static void distinctSortedNumberFromList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.distinctSortedNumberFromList()");
//        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
        numbers.stream().distinct().sorted().forEach(Java8FeatureWithInteger::printNumbers);
    }

    private static void distinctNumberFromList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.distinctNumberFromList()");
//        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
        numbers.stream().distinct().forEach(Java8FeatureWithInteger::printNumbers);
    }

    private static void sumOfEvenNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.sumOfEvenNumbers()");
        System.out.println(numbers.stream().filter(Java8FeatureWithInteger::isNumberEven).reduce(0, Integer::sum));
    }

    private static void sumOfOddNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.sumOfOddNumbers()");
        System.out.println(numbers.stream().filter(Java8FeatureWithInteger::isNumberOdd).reduce(0, Integer::sum));
    }

    private static void sumOfCubesOfEachNumbersInList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.sumOfCubesOfEachNumbersInList()");
        System.out.println(numbers.stream().map(Java8FeatureWithInteger::numberCube).reduce(0, Integer::sum));
    }

    private static void sumOfSquaresOfEachNumbersInList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.sumOfSquaresOfEachNumbersInList()");
        System.out.println(numbers.stream().map(Java8FeatureWithInteger::numberSquare).reduce(0, Integer::sum));
    }

    private static void reduceNumbersOfTheListToFindMinimum(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.reduceNumbersOfTheListToFindMinimum()");
        int reduceResult = numbers.stream().reduce(Integer.MAX_VALUE, (x1, x2) -> x1 > x2 ? x2 : x1);
        System.out.println(reduceResult);
    }

    private static void reduceNumbersOfTheListToFindMaximum(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.reduceNumbersOfTheListToFindMaximum()");
        int reduceResult = numbers.stream().reduce(Integer.MIN_VALUE, (x1, x2) -> x1 > x2 ? x1 : x2);
        System.out.println(reduceResult);
    }

    private Integer findMaximum(List<Integer> numbers) {
        int maxNumber = Integer.MIN_VALUE;
        for (Integer num : numbers) {
            if (num > maxNumber)
                maxNumber = num;
        }
        return maxNumber;
    }

    private static void reduceNumbersOfTheListToSecondParam(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.reduceNumbersOfTheListToSecondParam()");
        int reduceResult = numbers.stream().reduce(0, (x1, x2) -> x2);
        System.out.println(reduceResult);
    }

    private static void reduceNumbersOfTheListToFirstParam(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.reduceNumbersOfTheListToFirstParam()");
        int reduceResult = numbers.stream().reduce(0, (x1, x2) -> x1);
        System.out.println(reduceResult);
    }

    private static void sumAllNumbersOfTheList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.sumAllNumbersOfTheList()");
        System.out.println(numbers.stream().reduce(0, (x1, x2) -> x1 + x2));
    }

    private static void addNumbersToList(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.addNumbersToList()");
        List<Integer> integerList = numbers.stream().collect(Collectors.toList());
        System.out.println(integerList);
    }

    private static void printCubesOfAllOddNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printCubesOfAllOddNumbers()");
        System.out.println(numbers.stream()
                .filter(Java8FeatureWithInteger::isNumberOdd)
                .map(Java8FeatureWithInteger::numberCube)
                .collect(Collectors.toList()));
    }

    private static boolean isNumberOdd(Integer number) {
        return number % 2 != 0;
    }

    private static void printSquaresOfAllEvenNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printSquaresOfAllEvenNumbers()");
        System.out.println(numbers.stream()
                .filter(Java8FeatureWithInteger::isNumberEven)
                .map(Java8FeatureWithInteger::numberSquare)
                .collect(Collectors.toList()));
    }

    private static void printSquaresOfEachNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printAllSquaresOfEachNumbers()");
        System.out.println(numbers.stream()
                .map(Java8FeatureWithInteger::numberSquare)
                .collect(Collectors.toList()));
    }

    private static Integer numberSquare(Integer x) {
        return x * x;
    }

    private static Integer numberCube(Integer x) {
        return x * x * x;
    }

    private static void printAllOddNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printAllOddNumbersUsingLambdaExpression()");
        numbers.stream().filter(x -> x % 2 != 0).forEach(Java8FeatureWithInteger::printNumbers);
    }

    private static void printAllEvenNumbers(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printAllEvenNumbersUsingLambdaExpression()");
        numbers.stream().filter(Java8FeatureWithInteger::isNumberEven).forEach(Java8FeatureWithInteger::printNumbers);
    }

    public static void printAllNumbersUsingLambdaExpression(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printAllNumbersUsingLambdaExpression()");
        numbers.stream().forEach(System.out::println);
    }

    public static void printAllNumbersUsingMethodReference(List<Integer> numbers) {
        System.out.println("Java8FeatureWithInteger.printAllNumbersUsingMethodReference()");
        numbers.stream().forEach(Java8FeatureWithInteger::printNumbers);
    }

    private static void printNumbers(Integer x) {
        System.out.println(x);
    }

    private static Boolean isNumberEven(Integer x) {
        return x % 2 == 0;
    }

}
