package sshukla.java.solid.sip.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */

/**
 * 1. S: Single Responsibility Principle
 * 2. O: Open-Closed Principle
 * 3. L: Liskov Substitution Principle
 * 4. I: Interface Segregation Principle
 * 5. D: Dependency Inversion
 **/

public class Student_NON_SRP {

    private Long id;
    private String name;
    private String clazz;
    private Long rollNumber;

    public Student_NON_SRP() {
    }

    public Student_NON_SRP(Long id, String name, String clazz, Long rollNumber) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    public void printDetails() {
        //functionality of the method
    }

    public void calculatePercentage() {
        //functionality of the method
    }

    public void addStudent() {
        //functionality of the method
    }

    /**
     * Here we have created single class which has responsibility of holding Student class entity details
     * as well as API (printDetails(), calculatePercentage(), addStudent())
     * 
     * Instead we can create 4 different class, 1 to hold DTO responsibility, 3 different classes for different responsibility
     * i.e. printing details of students, calculating percentage of students and adding student data to database
     **/
}
