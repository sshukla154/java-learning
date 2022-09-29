package sshukla.java.solid.sip.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class Student {

    private Long id;
    private String name;
    private String clazz;
    private Long rollNumber;

    public Student() {
    }

    public Student(Long id, String name, String clazz, Long rollNumber) {
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

}
