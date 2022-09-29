package sshukla.java.solid.lsp.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class ElectricCar implements Car {

    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
        //this acceleration is crazy!
    }
}
