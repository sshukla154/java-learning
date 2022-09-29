package sshukla.java.solid.ocp.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class ElectricGuitar extends Guitar {

    private String guitarPower;
    private String cordLength;

    public ElectricGuitar() {
    }

    public ElectricGuitar(String make, String model, int volume, String guitarPower, String cordLength) {
        super(make, model, volume);
        this.guitarPower = guitarPower;
        this.cordLength = cordLength;
    }

    public String getGuitarPower() {
        return guitarPower;
    }

    public void setGuitarPower(String guitarPower) {
        this.guitarPower = guitarPower;
    }

    public String getCordLength() {
        return cordLength;
    }

    public void setCordLength(String cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public String toString() {
        return "ElectricGuitar{" +
                "guitarPower='" + guitarPower + '\'' +
                ", cordLength='" + cordLength + '\'' +
                '}';
    }
}
