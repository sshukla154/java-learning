package sshukla.java.warmup.hackerrank;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
public class FindTotal {

    public static void main(String[] args) {
        System.out.println(find_total(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println(find_total(new Integer[]{17, 19, 21}));
        System.out.println(find_total(new Integer[]{5, 5, 5}));

    }

    public static Integer find_total(Integer[] my_numbers) {
        //Insert your code here
        int x = 0;
        for (Integer integer : my_numbers) {
            if (integer == 5) {
                x = x + 5;
            } else if (integer % 2 == 0) {
                x = x + 1;
            } else if (integer % 2 != 0) {
                x = x + 3;
            }
        }
        return x;
    }

}
