package sshukla.java.warmup;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class CountingValleys {

    public static void main(String[] args) {

        System.out.println(countingValleys("DDUUUUDD"));
        System.out.println(countingValleys("UUDD"));
        System.out.println(countingValleys("UDDDUDUU"));
        System.out.println(countingValleys("DDUUDDUDUUUD"));
        System.out.println(countingValleys("DUDDDUUDUU"));
        System.out.println(countingValleys("DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD"));

    }

    public static int countingValleys(String path) {
        int onGround = 0;
        int inValley = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') {
                onGround--;
            }
            if (path.charAt(i) == 'U') {
                onGround++;
                if (onGround == 0) {
                    inValley++;
                }
            }

        }
        return inValley;
    }

}
