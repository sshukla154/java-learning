package sshukla.java.warmup.hackerrank;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class RepeatedString {

    public static void main(String[] args) {

        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000l));
        System.out.println(repeatedString("abcac", 109));

    }

    public static long repeatedString(String inputString, long noOfRepetition) {
        int noOfaInInputString = 0;
        for (char c : inputString.toCharArray()) {
            if (c == 'a')
                noOfaInInputString++;
        }

        int noOfaInSubstring = 0;
        long times = noOfRepetition / inputString.length();
        if ((times * inputString.length()) != noOfRepetition) {
            long myDiff = noOfRepetition - (times * inputString.length());
            for (char c : inputString.substring(0, (int) myDiff).toCharArray()) {
                if (c == 'a')
                    noOfaInSubstring++;
            }
            return (noOfaInInputString * times) + noOfaInSubstring;
        } else {
            return noOfaInInputString * times;
        }
    }

}
