package sshukla.java.version.eight;

import sshukla.java.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicsBrushUp {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        /**
         * IT=Optional[Employee{name='Anshul', department='IT', employeeID='102', salary=3000}]
         * EC=Optional[Employee{name='Hari', department='EC', employeeID='102', salary=30000}]
         * */

//        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        employeeList.add(new Employee("Mayur", "IT", "100", 1000));
        employeeList.add(new Employee("Raj", "IT", "101", 2000));
        employeeList.add(new Employee("Anshul", "IT", "102", 3000));
        employeeList.add(new Employee("Hari", "EC", "102", 3000));
        employeeList.add(new Employee("Ram", "EC", "102", 3000));

//        employeeList.stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));

//        System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));

    }
}
