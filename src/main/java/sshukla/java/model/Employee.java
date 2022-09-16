package sshukla.java.model;

import lombok.Data;

@Data
public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private String salary;

    public Employee(String name, String department, String salary, int employeeID) {
    }
}
