package sshukla.java.version.eight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '26/09/2022'
 */
public class Java8Grouping1 {

    /**
     * NOTE - 1 : Use Collectors.groupingBy() to get Map<K, V> out of List<String>, List<Integer>, List<Object>, List<Employee>, List<Course> etc
     * NOTE - 2 : Collectors.groupingBy(classifier) - Will give Map<Key, List<Value>> - Internally 1 parameter groupingBy() calls 2 parameter i.e. groupingBy(classifier, toList()), which uses Collectors.toList() as default value type.
     * NOTE - 3 : Collectors.groupingBy(classifier, Collectors.toList()) - Will give Map<Key, Set<Value>> - Internally 2 parameter groupingBy() calls 3 parameter i.e. groupingBy(classifier, Hashmap::new, downstream), which uses HashMap() as default sorting.
     **/

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "James", 54, "Male", List.of("New York", "Los Angeles", "San Francisco")),
                new Employee(2, "Patricia", 23, "Female", List.of("Chicago", "Los Angeles", "San Francisco")),
                new Employee(3, "John", 56, "Male", List.of("Washington")),
                new Employee(4, "Michael", 42, "Male", List.of("San Diego")),
                new Employee(5, "David", 26, "Male", List.of("Las Vegas", "Chicago")),
                new Employee(6, "Linda", 92, "Female", List.of("Chicago", "Durham")),
                new Employee(7, "Karen", 22, "Female", List.of("Chicago")),
                new Employee(8, "Jennifer", 45, "Female", List.of("Las Vegas", "Durham")),
                new Employee(9, "Thomas", 54, "Male", List.of("Detroit")),
                new Employee(10, "Jennifer", 45, "Female", List.of("Durham")),
                new Employee(11, "Thomas", 54, "Male", List.of("Las Vegas"))
        );

        Map<String, List<String>> groupingByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getEmployeeName, Collectors.toList())));
        System.out.println("Grouping By Gender - " + groupingByGender);

        Map<Integer, List<String>> groupingByAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getEmployeeName, Collectors.toList())));
        System.out.println("Grouping By Age - " + groupingByAge);

        Map<Integer, Set<String>> distinctGroupingByAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getEmployeeName, Collectors.toSet())));
        System.out.println("Distinct Grouping By Age - " + distinctGroupingByAge);

        //This wont give the correct output (e.g. as below). We can observe that in age 54 and 45 we have duplicate records of Jennifer and Thomas. So to solve this we need to override equals() and hashcode() in Employee class of name and age
        /**Distinct Grouping By Age with Complete employee details -
         {54=[Employee{employeeId=1, employeeName='James', age=54, gender='Male'}, Employee{employeeId=9, employeeName='Thomas', age=54, gender='Male'}, Employee{employeeId=11, employeeName='Thomas', age=54, gender='Male'}],
         23=[Employee{employeeId=2, employeeName='Patricia', age=23, gender='Female'}],
         56=[Employee{employeeId=3, employeeName='John', age=56, gender='Male'}],
         26=[Employee{employeeId=5, employeeName='David', age=26, gender='Male'}],
         92=[Employee{employeeId=6, employeeName='Linda', age=92, gender='Female'}],
         12=[Employee{employeeId=7, employeeName='Karen', age=12, gender='Female'}, Employee{employeeId=4, employeeName='Michael', age=12, gender='Male'}],
         45=[Employee{employeeId=8, employeeName='Jennifer', age=45, gender='Female'}, Employee{employeeId=10, employeeName='Jennifer', age=45, gender='Female'}]}**/
        //After overriding equals() and hashCode() in Employee class, we get below output
        /**Distinct Grouping By Age with Complete employee details -
         {54=[Employee{employeeId=9, employeeName='Thomas', age=54, gender='Male'}, Employee{employeeId=1, employeeName='James', age=54, gender='Male'}],
         23=[Employee{employeeId=2, employeeName='Patricia', age=23, gender='Female'}],
         56=[Employee{employeeId=3, employeeName='John', age=56, gender='Male'}],
         26=[Employee{employeeId=5, employeeName='David', age=26, gender='Male'}],
         92=[Employee{employeeId=6, employeeName='Linda', age=92, gender='Female'}],
         12=[Employee{employeeId=7, employeeName='Karen', age=12, gender='Female'}, Employee{employeeId=4, employeeName='Michael', age=12, gender='Male'}],
         45=[Employee{employeeId=8, employeeName='Jennifer', age=45, gender='Female'}]}**/
        Map<Integer, Set<Employee>> distinctGroupingByAge1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.toSet()));
        System.out.println("Distinct Grouping By Age with Complete employee details - " + distinctGroupingByAge1);

        Map<Integer, Set<Employee>> distinctGroupingByAge2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, TreeMap::new, Collectors.toSet()));
        System.out.println("Distinct Sorted Grouping By Age with Complete employee details - " + distinctGroupingByAge2);


        //get list of cities in which employees have worked upon
        List<String> distinctListOfCitiesOfAllEmployees = employeeList.stream().map(Employee::getCitiesWorkedIn).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println("Distinct list Of cities of all employees - " + distinctListOfCitiesOfAllEmployees);

        List<String> distinctListOfCitiesOfAllEmployees1 = employeeList.stream().flatMap(x -> x.getCitiesWorkedIn().stream()).distinct().collect(Collectors.toList());
        System.out.println("Distinct list Of cities of all employees - 1 - " + distinctListOfCitiesOfAllEmployees1);


    }

}
