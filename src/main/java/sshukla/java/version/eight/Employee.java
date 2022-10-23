package sshukla.java.version.eight;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Employee {
    private int employeeId;
    private String employeeName;
    private Integer age;
    private String gender;

    private List<String> citiesWorkedIn;

    public Employee() {
        super();
    }

    public Employee(int employeeId, String employeeName, Integer age, String gender, List<String> citiesWorkedIn) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.citiesWorkedIn = citiesWorkedIn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getCitiesWorkedIn() {
        return citiesWorkedIn;
    }

    public void setCitiesWorkedIn(List<String> citiesWorkedIn) {
        this.citiesWorkedIn = citiesWorkedIn;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!employeeName.equals(employee.employeeName)) return false;
        return age.equals(employee.age);
    }

    @Override
    public int hashCode() {
        int result = employeeName.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}
