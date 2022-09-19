package sshukla.java.generics;

import java.io.Serializable;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class BoundedWithInterfaceGenericsPrinter<T extends Animal & Serializable & Cloneable> {
    T inputToPrint;

    public BoundedWithInterfaceGenericsPrinter(T input) {
        this.inputToPrint = input;
    }

    public void print() {
        System.out.println(inputToPrint);
    }
}
