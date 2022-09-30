package sshukla.java.equalsandhashcodecontract;

/**
 * @author 'Seemant Shukla' on '29/09/2022'
 */
public class EqualAndHashCodeContract {

    /**
     * If, object1.equals(object2) = true than object1.hashcode() and object2.hashcode() will be same
     * If, object1.equals(object2) = false than object1.hashcode() and object2.hashcode() can be same or different
     * If, object1.hashcode() == object2.hashcode() than object1.equals(object2) = true/false
     * If, object1.hashcode() != and object2.hashcode() than object1.equals(object2) = false
     * <p>
     * 1. If, r1==r2 is true, r1.equals(r2) is always true
     * 2. If, r1==r2 is false, r1.equals(r2) can be true/false
     * 3. If, r1.equals(r2) is true, r1==r2 can be true/false
     * 4. If, r1.equals(r2) is false, then r1==r2 is always false
     **/

    public static void main(String[] args) {
        EmployeeWithoutEqualsAndHashcode employeeWithoutEqualsAndHashcode1 = new EmployeeWithoutEqualsAndHashcode(1L, "SShukla");
        EmployeeWithoutEqualsAndHashcode employeeWithoutEqualsAndHashcode2 = new EmployeeWithoutEqualsAndHashcode(1L, "SShukla");

        System.out.println("Comparing with equals() : --- " + employeeWithoutEqualsAndHashcode1.equals(employeeWithoutEqualsAndHashcode2));//false
        System.out.println("Comparing with == : --- " + (employeeWithoutEqualsAndHashcode1 == employeeWithoutEqualsAndHashcode2));
        System.out.println("Comparing hashcode() : --- " + (employeeWithoutEqualsAndHashcode1.hashCode() + ", " + employeeWithoutEqualsAndHashcode2.hashCode()));//true or false

        System.out.println("*************");
        EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode1 = new EmployeeWithEqualsAndHashCode(1L, "SShukla");
        EmployeeWithEqualsAndHashCode employeeWithEqualsAndHashCode2 = new EmployeeWithEqualsAndHashCode(1L, "SShukla");

        System.out.println("Comparing with equals() : --- " + employeeWithEqualsAndHashCode1.equals(employeeWithEqualsAndHashCode2));//true
        System.out.println("Comparing with == : --- " + (employeeWithEqualsAndHashCode1 == employeeWithEqualsAndHashCode2));
        System.out.println("Comparing hashcode() : --- " + (employeeWithEqualsAndHashCode1 + ", " + employeeWithEqualsAndHashCode2));//true

    }

}
