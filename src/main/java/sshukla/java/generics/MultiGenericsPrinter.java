package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class MultiGenericsPrinter<T, V> {
    T inputToPrint;
    V anotherInputToPrint;

    public MultiGenericsPrinter(T input, V anotherInputToPrint) {
        this.inputToPrint = input;
        this.anotherInputToPrint = anotherInputToPrint;
    }

    public void print() {
        System.out.println(inputToPrint + " --- " + anotherInputToPrint);
    }
}
