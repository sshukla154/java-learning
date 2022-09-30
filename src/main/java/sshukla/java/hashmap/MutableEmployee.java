package sshukla.java.hashmap;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '30/09/2022'
 */
public class MutableEmployee implements Cloneable {
    private int employeeId;
    private String employeeName;
    private Integer age;
    private String gender;

    private List<String> citiesWorkedIn;

    public MutableEmployee(int employeeId, String employeeName, Integer age, String gender, List<String> citiesWorkedIn) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.citiesWorkedIn = citiesWorkedIn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getCitiesWorkedIn() {
        return citiesWorkedIn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", citiesWorkedIn=" + citiesWorkedIn +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone Not Supported Exception - This is immutable class");
    }

}
