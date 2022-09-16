package sshukla.java;

import sshukla.java.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class BasicsBrushUp {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        /**
         * IT=Optional[Employee{name='Anshul', department='IT', employeeID='102', salary=3000}]
         * EC=Optional[Employee{name='Hari', department='EC', employeeID='102', salary=30000}]
         * */

        employeeList.add(new Employee("Mayur", "IT", "100", 1000));
        employeeList.add(new Employee("Raj", "IT", "101", 2000));
        employeeList.add(new Employee("Anshul", "IT", "102", 3000));
        employeeList.add(new Employee("Hari", "EC", "102", 3000));
        employeeList.add(new Employee("Ram", "EC", "102", 3000));

//        employeeList.stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));


    }
}
