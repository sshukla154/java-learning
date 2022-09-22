package sshukla.java.warmup.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class GradingStudents {

    public static void main(String[] args) {

        System.out.println(gradingStudents(Arrays.asList(73, 67, 38, 33)));

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        //Difference between : grade and next multiple is less than 3 than grade goes up
        //Difference between : grade and next multiple is 3 or more than nothing happens to grade
        List<Integer> newGrades = new LinkedList<>();
        for (Integer num : grades) {
            int i = (num / 5) + 1;
            newGrades.add((((i * 5) - num) >= 3 || num < 38) ? num : (i * 5));
        }

        return newGrades;
    }

}
