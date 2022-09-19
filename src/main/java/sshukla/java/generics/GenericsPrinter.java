package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class GenericsPrinter<T> {
    T inputToPrint;

    public GenericsPrinter(T input) {
        this.inputToPrint = input;
    }

    public void print() {
        System.out.println(inputToPrint);
    }
}
