package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class DoublePrinter {
    Double inputToPrint;

    public DoublePrinter(Double input) {
        this.inputToPrint = input;
    }

    public void print() {
        System.out.println(inputToPrint);
    }
}
