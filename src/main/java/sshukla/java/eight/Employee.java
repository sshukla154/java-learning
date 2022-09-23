package sshukla.java.eight;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Employee {
    private int employeeId;
    private String employeeName;

    public Employee() {
        super();
    }

    public Employee(int employeeId, String employeeName) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
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

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
    }
}
