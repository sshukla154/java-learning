package sshukla.java.comparatorvscomparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '24/09/2022'
 */
public class ComparatorVsComparableExample {

    public static void main(String[] args) {


        //Using java 8
        List<Customer> customerList = Arrays.asList(
                new Customer(1, "Shashank", "email1@gmail.com", Arrays.asList("123", "4356", "5453")),
                new Customer(2, "Shivam", "email1@gmail.com", Arrays.asList("56432", "123456765", "132456765432")),
                new Customer(3, "Shivam", "email1@gmail.com", Arrays.asList("2134563", "23145632", "342564533")),
                new Customer(4, "Dev", "email1@gmail.com", Arrays.asList("987876", "435355434", "22113131")),
                new Customer(5, "Ved", "email1@gmail.com", Arrays.asList("2345242", "23452443", "324231411")),
                new Customer(6, "Nikhil", "email1@gmail.com", Arrays.asList("1123423", "4356", "5453")),
                new Customer(7, "Om", "email1@gmail.com", Arrays.asList("98721345", "234568987", "45632114"))
        );
        List<Customer> sortCustomerByNameAndThenReversedId = customerList.stream().sorted(Comparator.comparing(Customer::getName).thenComparing(Customer::getId).reversed()).collect(Collectors.toList());
        System.out.println(sortCustomerByNameAndThenReversedId);

        List<Student> studentList = Arrays.asList(
                new Student("Shashank", 432112343, 35),
                new Student("Shivam", 123456, 30),
                new Student("Shivam", 76541234, 30),
                new Student("Dev", 22113131, 15),
                new Student("Ved", 324231411, 3),
                new Student("Nikhil", 1123423, 31),
                new Student("Om", 45632114, 12));

        Collections.sort(studentList);
        studentList.forEach(System.out::println);

    }

}
