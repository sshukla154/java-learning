package sshukla.java.warmup.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(Arrays.asList(3, 2, 1, 3)));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int maxNumber = Integer.MIN_VALUE;
        int maxNumberCount = 0;
        for (Integer candle : candles) {
            if (candle == maxNumber) {
                maxNumberCount++;
            } else if (candle > maxNumber) {
                maxNumber = candle;
                maxNumberCount = 1;
            }

        }
//        return Math.toIntExact(candles.stream().filter(x -> Objects.equals(x, Collections.max(candles))).count());
        return maxNumberCount;
    }

}
