package sshukla.java.threads.executorservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 'Seemant Shukla' on '20/10/2022'
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @JsonProperty("employeeId")
    private String employeeId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("newJoiner")
    private String newJoiner;

    @JsonProperty("learningPending")
    private String learningPending;

    @JsonProperty("salary")
    private int salary;

    @JsonProperty("rating")
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
