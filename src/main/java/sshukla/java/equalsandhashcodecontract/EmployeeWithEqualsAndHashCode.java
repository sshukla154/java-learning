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
public class EmployeeWithEqualsAndHashCode {

    private Long id;
    private String name;

    public EmployeeWithEqualsAndHashCode(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeWithEqualsAndHashCode)) return false;

        EmployeeWithEqualsAndHashCode that = (EmployeeWithEqualsAndHashCode) o;

        if (!id.equals(that.id)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
