package sshukla.java.equalsandhashcodecontract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 'Seemant Shukla' on '29/09/2022'
 */

@Getter
@Setter
@NoArgsConstructor
public class EmployeeWithoutEqualsAndHashcode {

    private Long id;
    private String name;

    public EmployeeWithoutEqualsAndHashcode(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
