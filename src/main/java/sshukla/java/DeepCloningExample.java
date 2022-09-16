package sshukla.java;

/**
 * @author 'Seemant Shukla' on '16/09/2022'
 */
public class DeepCloningExample {
}

class DCEmployee implements Cloneable {

    Long employeeId;
    String employeeName;
    DCDepartment department;

    public DCEmployee(Long employeeId, String employeeName, DCDepartment department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DCEmployee clonedDCEmployee = (DCEmployee) super.clone();
        clonedDCEmployee.department = this.department.clone();
        return clonedDCEmployee;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
                + "]";
    }
}

class DCDepartment implements Cloneable {

    Long departmentId;
    String grade;
    String designation;

    public DCDepartment(Long departmentId, String grade, String designation) {
        this.departmentId = departmentId;
        this.grade = grade;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", grade=" + grade + ", designation=" + designation + "]";
    }

    @Override
    public DCDepartment clone() {
        try {
            return (DCDepartment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
