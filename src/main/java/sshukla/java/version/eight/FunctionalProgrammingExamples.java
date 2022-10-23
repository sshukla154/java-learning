package sshukla.java.version.eight;

import java.util.List;

public class FunctionalProgrammingExamples {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllNumbersInListStructured(numbers);

        printMyString("******");

        printAllNumbersInFunctionalStructured(numbers);

        printMyString("******");

        printEvenNumbersInListStructured(numbers);

        printMyString("******");

        printEvenNumbersInFunctionalStructured(numbers);

    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for (Integer i : numbers) {
            System.out.println(i);
        }
    }

    private static void printAllNumbersInFunctionalStructured(List<Integer> numbers) {
        /** Using Method Reference*/
//        numbers.stream().forEach(FunctionalProgrammingExamples::printMyNumber);
        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    private static void printEvenNumbersInFunctionalStructured(List<Integer> numbers) {
        /** Using Lambda expression*/
        numbers.stream().filter(x -> x % 2 == 0).forEach(x -> printMyNumber(x));
    }

    private static void printMyNumber(Integer myNumber) {
        System.out.println(myNumber);
    }

    private static void printMyString(String myString) {
        System.out.println(myString);
    }

}