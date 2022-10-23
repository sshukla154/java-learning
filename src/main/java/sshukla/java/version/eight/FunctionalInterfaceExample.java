package sshukla.java.version.eight;

/**
 * @author 'Seemant Shukla' on '18/09/2022'
 */

/**
 * 1. One and only one abstract methods
 * 2. Any number of default method
 * 3. Any number of static method
 * 4. Optionally have @FunctionalInterface annotation
 */

@FunctionalInterface
public interface FunctionalInterfaceExample {

    // Only one - If we uncomment testAbstractMethod1, we will get CTE stating, either remove @FunctionalInterface or remove one abstract method from this interface
    boolean testAbstractMethod(Integer input1, Integer input2);
    // boolean testAbstractMethod1(Integer input1, Integer input2);

    default Integer testDefaultMethod1(Integer input1, Integer input2) {
        return input1 + input2;
    }

    default Boolean testDefaultMethod2(String input1, String input2) {
        return input1.length() > input2.length();
    }

    default Integer testDefaultMethod3(String input1, Integer input2) {
        return input1.length() + input2;
    }

    static Integer testStaticMethod1(Integer input1, Integer input2) {
        return input1 + input2;
    }

    static Boolean testStaticMethod2(String input1, String input2) {
        return input1.length() > input2.length();
    }

    static Integer testStaticMethod3(String input1, Integer input2) {
        return input1.length() + input2;
    }

    static Integer testStaticMethod4(String input1, Integer input2) {
        return input1.length() + input2;
    }

}
