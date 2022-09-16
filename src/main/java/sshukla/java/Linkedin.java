package sshukla.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 'Seemant Shukla' on '12/07/2022'
 */
public class Linkedin {

    static Exception print(int i){
        if (i>0) {
            return new Exception();
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Interface1.print(); Interface2.print();

        System.out.println();
        System.out.println("------");
        String str = "abcde";
        str.trim();
        str.toUpperCase();
        str.substring(3, 4);
        System.out.println(str);

        System.out.println("------");
        System.out.println(print(1));

        System.out.println("------");
        List list = new ArrayList<>();
        list.add("hello");
        list.add(2);
        System.out.println(list.get(0) != null);
        System.out.println(list.get(0) instanceof Object);
        System.out.println(list.get(0) instanceof String);
        System.out.println(list.get(1) instanceof Integer);
    }
}
interface Interface1 {
    static void print() {
        System.out.print("Hello");
    }
}

interface Interface2 {
    static void print() {
        System.out.print("World!");
    }
}

interface One {
    default void method() {
        System.out.println("One");
    }
}

interface Two {
    default void method () {
        System.out.println("One");
    }
}