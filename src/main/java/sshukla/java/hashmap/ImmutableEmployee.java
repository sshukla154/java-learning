package sshukla.java.hashmap;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '30/09/2022'
 */
public final class ImmutableEmployee implements Cloneable {
    private final int employeeId;
    private final String employeeName;
    private final Integer age;
    private final String gender;

    private final List<String> citiesWorkedIn;


    //Perform Deep-Cloning
    public ImmutableEmployee(int employeeId, String employeeName, Integer age, String gender, List<String> citiesWorkedIn) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.citiesWorkedIn = citiesWorkedIn.stream().collect(Collectors.toList());
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

    //Perform Deep-Cloning
    public List<String> getCitiesWorkedIn() {
        return citiesWorkedIn.stream().collect(Collectors.toList());
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
