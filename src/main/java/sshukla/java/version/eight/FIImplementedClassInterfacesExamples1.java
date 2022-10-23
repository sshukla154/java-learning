package sshukla.java.version.eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author 'Seemant Shukla' on '23/09/2022'
 */
public class FIImplementedClassInterfacesExamples1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Step-1
        numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("===========================");

        //
        BinaryOperator<Integer> summationBinaryOperator = Integer::sum;
        numbers.stream()
                .reduce(0, summationBinaryOperator);
        System.out.println("===========================");

        //
        BinaryOperator<Integer> summationBinaryOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer number1, Integer number2) {
                return number1 + number2;
            }
        };
        numbers.stream()
                .reduce(0, summationBinaryOperator1);
        System.out.println("===========================");
        BinaryOperator<Integer> summationBinaryOperator3 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer number1, Integer number2) {
                return number1 + number2;
            }
        };
        numbers.stream()
                .reduce(0, summationBinaryOperator3);

    }
}
