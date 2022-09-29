package sshukla.java.solid.ocp.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */

/**
 * S - Single Responsibility Principle
 * O - Open Closed Principle
 * L - Liskov Substitution Principle
 * I - Interface Segregation Principle
 * D - Dependency Inversion Principle
 **/

public class Guitar {
    private String make;
    private String model;
    private int volume;

    public Guitar() {
    }

    public Guitar(String make, String model, int volume) {
        this.make = make;
        this.model = model;
        this.volume = volume;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                '}';
    }
}
