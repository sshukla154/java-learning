package sshukla.java.threads.executorservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author 'Seemant Shukla' on '20/10/2022'
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private String learningPending;
    private int salary;
    private int rating;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", newJoiner='" + newJoiner + '\'' +
                ", learningPending='" + learningPending + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }
}
