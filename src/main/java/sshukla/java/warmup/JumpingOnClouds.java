package sshukla.java.warmup;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class JumpingOnClouds {

    public static void main(String[] args) {

        System.out.println(jumpingOnClouds(List.of(0, 1, 0, 0, 0, 1, 0)));
//        System.out.println(jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0)));
//        System.out.println(jumpingOnClouds(List.of(0, 0, 0, 0, 1, 0)));

    }

    public static int jumpingOnClouds(List<Integer> input) {
        // 1. jump next only if next-to-next is 1
        int minJumpCount = 0;
        for (int i = 0; i < input.size(); i++) {
            System.out.println("Value of i : " + i);
            if (input.get(i + 1) == 0) {
                i = i + 2;
            }
            minJumpCount++;
        }

        return minJumpCount;
    }

}
