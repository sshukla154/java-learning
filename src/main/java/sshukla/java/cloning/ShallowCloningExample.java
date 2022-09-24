package sshukla.java.cloning;

/**
 * @author 'Seemant Shukla' on '16/09/2022'
 */
public class ShallowCloningExample {
}

class SCEmployee implements Cloneable {

    Long employeeId;
    String employeeName;
    SCDepartment department;

    public SCEmployee(Long employeeId, String employeeName, SCDepartment department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
                + "]";
    }
}

class SCDepartment implements Cloneable {

    Long departmentId;
    String grade;
    String designation;

    public SCDepartment(Long departmentId, String grade, String designation) {
        this.departmentId = departmentId;
        this.grade = grade;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", grade=" + grade + ", designation=" + designation + "]";
    }
}
