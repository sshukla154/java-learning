package sshukla.java;

import java.util.List;
import java.util.Map;

/**
 * @author 'Seemant Shukla' on '16/09/2022'
 */
public class ImmutableAndCloningClient {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("Immutable Test - Can't be modified once the object is created");
        List<String> phoneNumbers = List.of("+9197455523", "+91942653009", "+316447600000009");
        Map<String, Integer> performance = Map.of("input1", 123, "input2", 234, "input3", 345);
        Address address = new Address(65467, "458ABC", "Netherlands");
        EmployeeImmutableClassExample employeeImmutableClassExample = new EmployeeImmutableClassExample(1, "S Shukla", phoneNumbers, performance, address);

        System.out.println(employeeImmutableClassExample);
        address.setCountry("India");
        System.out.println(employeeImmutableClassExample);

        // this.address = (Address) address.clone(); -- Comment this line in EmployeeImmutableClassExample.java class and verify the above output.

        System.out.println("Deep-Cloning Test - Modified inner object i.e. DCDepartment, is not reflected in main object i.e. DCEmployee");
        DCDepartment dcdepartment = new DCDepartment(1L, "SSE", "R&D");
        DCEmployee dcEmployee = new DCEmployee(1L, "Seemant Shukla", dcdepartment);

        // Copy Employee details to another object
        DCEmployee dcEmployeeNew = null;
        try {
            dcEmployeeNew = (DCEmployee) dcEmployee.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(dcEmployee.toString());
        dcEmployeeNew.department.designation = "I am saved - I am of no use !!!";
        System.out.println(dcEmployee.toString());

        System.out.println("Shallow-Cloning Test - Modified inner object i.e. SCDepartment, reflected in main object i.e. SCEmployee");
        SCDepartment scdepartment = new SCDepartment(1L, "SSE", "R&D");
        SCEmployee scEmployee = new SCEmployee(1L, "Seemant Shukla", scdepartment);

        SCEmployee scEmployeeNew = null;
        try {
            scEmployeeNew = (SCEmployee) scEmployee.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(scEmployee.toString());
        scEmployeeNew.department.designation = "Fucked Up !!!";
        System.out.println(scEmployee.toString());

    }

}
