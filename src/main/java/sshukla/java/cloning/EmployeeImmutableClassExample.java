package sshukla.java.cloning;

/**
 * @author 'Seemant Shukla' on '16/09/2022'
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Immutable: Once the object is created, it cannot be modified at later stage. Cannot be extended
 * 1. Class should be final - So cannot be extended
 * 2. NO no-args constructor - so all the variable defined should be set while at the time of object creation i.e. only parameterized constructor
 * 3. Variables defined - Cannot be set once the object is created i.e. no setter
 * 4. Variables defined - Should not be modified at later stage i.e. all variables should be final
 * 5. Variables defined - Should not have direct access i.e. private
 * 6. For collection type of variable, we should return each value instead of object while perform get operation i.e. deep cloning
 */

public final class EmployeeImmutableClassExample {

    private final Integer id;
    private final String name;
    private final List<String> phoneNumbers;

    private final Map<String, Integer> performance;

    private final Address address;


    public EmployeeImmutableClassExample(Integer id, String name, List<String> phoneNumbers, Map<String, Integer> performance, Address address) throws CloneNotSupportedException {
        this.id = id;
        this.name = name;

        //Deep-Cloning of phoneNumbers
        List<String> tempPhoneNumbers = new ArrayList<>();
        for (String phoneNumber : phoneNumbers) {
            tempPhoneNumbers.add(phoneNumber);
        }
        this.phoneNumbers = tempPhoneNumbers;

        //Deep-Cloning of performance
        Map<String, Integer> tempPerformance = new HashMap<>();
        for (Map.Entry<String, Integer> entry : performance.entrySet()) {
            tempPerformance.put(entry.getKey(), entry.getValue());
        }
        this.performance = tempPerformance;

        //Deep-Cloning of address
        this.address = (Address) address.clone();
//        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
//        return phoneNumbers;
        // Deep Cloning
        List<String> tempPhoneNumbers = new ArrayList<>();
        for (String phoneNumber : this.phoneNumbers) {
            tempPhoneNumbers.add(phoneNumber);
        }
        return tempPhoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public Map<String, Integer> getPerformance() {
//        return performance;
        // Deep Cloning
        Map<String, Integer> tempMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : this.performance.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

    @Override
    public String toString() {
        return "EmployeeImmutableClassExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", performance=" + performance +
                ", address=" + address +
                '}';
    }
}

