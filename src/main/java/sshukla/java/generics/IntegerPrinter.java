package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class IntegerPrinter {

    Integer inputToPrint;

    public IntegerPrinter(Integer input) {
        this.inputToPrint = input;
    }

    public void print(){
        System.out.println(inputToPrint);
    }
}
