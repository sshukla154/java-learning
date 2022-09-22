package sshukla.java.warmup.hackerrank;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class JumpingOnClouds {

    public static void main(String[] args) {

        System.out.println(jumpingOnClouds(List.of(0, 1, 0, 0, 0, 1, 0)));
        System.out.println(jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0)));
        System.out.println(jumpingOnClouds(List.of(0, 0, 0, 0, 1, 0)));
        System.out.println(jumpingOnClouds(List.of(0, 0, 1, 0, 0, 0, 0, 1, 0, 0)));

    }

    public static int jumpingOnClouds(List<Integer> input) {
        // 1. jump next only if next-to-next is 1
        int minJumpCount = 0;
        int i = 0;
        while (i < (input.size() - 1)) {
            if ((i + 2) <= (input.size() - 1) && input.get(i + 2) == 0) {
                i++;
            }
            i++;
            minJumpCount++;
        }

        return minJumpCount;
    }

}
