package sshukla.java;

/**
 * @author 'Seemant Shukla' on '09/10/2022'
 */
public class StringExample {
    public static void main(String[] args) {
        String s1 = new String("Hello World!!!");
        String s2 = "Hello World!!!";
        //intern()
        System.out.println(s1.intern());
        System.out.println(s1.intern().hashCode() == s2.hashCode());

        String s3 = "Hello" + new String(" World!!!");
        String s4 = "Hello";
        String s5 = s4.concat(" World!!!");
        //intern()
        System.out.println(s4);// This shows String is Immutable
        System.out.println(s5.intern().hashCode() == s1.intern().hashCode());// This shows Hello World!!! once created in SCP it is reused everytime.
        System.out.println(s3.intern().hashCode() == s1.intern().hashCode());// This shows Hello World!!! once created in SCP it is reused everytime.
    }
}
