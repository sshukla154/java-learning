package sshukla.java.warmup.hackerrank;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class NumberCloseToZero {

    public static void main(String[] args) {


        int[] numbers = {7, -10, 13, 8, 4, -7, -12, 3, -3, -9, 6, -1, -6, 7};
        nearestToZero(numbers);
        int[] numbers1 = {7, 5, 9, 1, 4};
        nearestToZero(numbers1);
        int[] numbers2 = {-15, -7, -9, -14, -12};
        nearestToZero(numbers2);
        int[] numbers3 = {-10, -10};
        nearestToZero(numbers3);
        int[] numbers4 = {0};
        nearestToZero(numbers4);
        int[] numbers5 = {15, -7, 9, 14, 7, 12};
        nearestToZero(numbers5);
    }

    private static int nearestToZero(int[] numbers) {
        int positiveNumber = 0;
        int negativeNumber = 0;

        Arrays.sort(numbers);
        //If all positive
        if (Arrays.stream(numbers).allMatch(x -> x > 0)) {
            System.out.println("Output : " + numbers[0]);
            return numbers[0];
        }
        //If all negative
        if (Arrays.stream(numbers).allMatch(x -> x < 0)) {
            System.out.println("Output : " + numbers[numbers.length - 1]);
            return numbers[numbers.length - 1];
        }

        for (int number : numbers) {
            if (positiveNumber == 0 && number > 0) {
                positiveNumber = number;
            } else if (number > 0 && positiveNumber > number) {
                positiveNumber = number;
            } else if (negativeNumber == 0 && number < 0) {
                negativeNumber = number;
            } else if (number < 0 && negativeNumber < number) {
                negativeNumber = number;
            }
        }

        if (Math.abs(positiveNumber) < Math.abs(negativeNumber)) {
            System.out.println("Output : " + positiveNumber);
            return positiveNumber;
        } else if (Math.abs(positiveNumber) > Math.abs(negativeNumber)) {
            System.out.println("Output : " + negativeNumber);
            return negativeNumber;
        } else {
            System.out.println("Output : " + negativeNumber);
            return negativeNumber;
        }
    }

}
