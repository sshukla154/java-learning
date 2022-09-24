package sshukla.java.cloning;

public class Address implements Cloneable {

    private Integer id;
    private String houseNumber;
    private String country;

    public Address(Integer id, String houseNumber, String country) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseNumber='" + houseNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
