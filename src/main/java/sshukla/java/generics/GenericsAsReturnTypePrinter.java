package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class GenericsAsReturnTypePrinter<T> {
    T inputToPrint;

    public GenericsAsReturnTypePrinter(T input) {
        this.inputToPrint = input;
    }

    public T print(T inputToPrint) {
        return inputToPrint;
    }
}
