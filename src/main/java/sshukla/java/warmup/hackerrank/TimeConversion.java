package sshukla.java.warmup.hackerrank;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class TimeConversion {

    public static void main(String[] args) {

        System.out.println(timeConversion("12:01:00PM"));
        System.out.println(timeConversion("12:01:00AM"));
        System.out.println(timeConversion("07:05:45PM"));

    }

    public static String timeConversion(String inputTime) {
        if (inputTime.contains("AM"))
            return "I have AM";

        return "";
    }

}
