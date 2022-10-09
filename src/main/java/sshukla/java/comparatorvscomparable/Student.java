package sshukla.java.comparatorvscomparable;

/**
 * @author 'Seemant Shukla' on '30/09/2022'
 */
public class Student implements Comparable<Student> {

    private String name;
    private Integer rollNumber;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer rollNumber, Integer age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //Sort By AGE
    @Override
    public int compareTo(Student student) {
        if (student.getAge() == age)
            return 0;
        if (student.getAge() < age)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", age=" + age +
                '}';
    }
}
