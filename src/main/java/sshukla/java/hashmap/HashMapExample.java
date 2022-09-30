package sshukla.java.hashmap;

import java.util.*;

/**
 * @author 'Seemant Shukla' on '29/09/2022'
 */
public class HashMapExample {

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = new HashMap();
        stringIntegerMap.put("Seemant", 1);
        stringIntegerMap.put("Shukla", 2);
        stringIntegerMap.put("Seemant", 3);
        System.out.println("String Integer Map :- " + stringIntegerMap);

        System.out.println("Mutable Employee==================> ");
        Map<MutableEmployee, Integer> mutableEmployeeIntegerMap = new HashMap();
        List<String> mutableEmployee1CitiesWorkedIn = getCitiesWorkedIn("New Delhi", "Trivandrum", "Bangalore", "Haarlem");
        List<String> mutableEmployee2CitiesWorkedIn = getCitiesWorkedIn("New Delhi", "Kota", "Dehradun", "Haldwani");
        MutableEmployee mutableEmployee1 = new MutableEmployee(123, "SShukla154", 34, "Male", mutableEmployee1CitiesWorkedIn);
        MutableEmployee mutableEmployee2 = new MutableEmployee(234, "SShukla490", 30, "Male", mutableEmployee2CitiesWorkedIn);
        mutableEmployeeIntegerMap.put(mutableEmployee1, 1);
        mutableEmployeeIntegerMap.put(mutableEmployee2, 2);
        System.out.println("Employee Integer Map :- " + mutableEmployeeIntegerMap);

        // Now trying to all one more city in immutableEmployee1CitiesWorkedIn
        mutableEmployee1CitiesWorkedIn.add("Gorakhpur");
        System.out.println("Employee Integer Map :- " + mutableEmployeeIntegerMap);


        System.out.println("Immutable Employee==================> ");


        Map<ImmutableEmployee, Integer> immutableEmployeeIntegerMap = new HashMap();
        List<String> immutableEmployee1CitiesWorkedIn = getCitiesWorkedIn("New Delhi", "Trivandrum", "Bangalore", "Haarlem");
        List<String> immutableEmployee2CitiesWorkedIn = getCitiesWorkedIn("New Delhi", "Kota", "Dehradun", "Haldwani");
        ImmutableEmployee immutableEmployee1 = new ImmutableEmployee(123, "SShukla154", 34, "Male", immutableEmployee1CitiesWorkedIn);
        ImmutableEmployee immutableEmployee2 = new ImmutableEmployee(234, "SShukla490", 30, "Male", immutableEmployee2CitiesWorkedIn);
        immutableEmployeeIntegerMap.put(immutableEmployee1, 1);
        immutableEmployeeIntegerMap.put(immutableEmployee2, 2);
        System.out.println("Employee Integer Map :- " + immutableEmployeeIntegerMap);

        // Now trying to all one more city in immutableEmployee1CitiesWorkedIn
        immutableEmployee1CitiesWorkedIn.add("Gorakhpur");
        System.out.println("Employee Integer Map :- " + immutableEmployeeIntegerMap);


    }

    private static List<String> getCitiesWorkedIn(String city1, String city2, String city3, String city4) {
        List<String> mutableEmployee1CitiesWorkedIn = new ArrayList<>();
        mutableEmployee1CitiesWorkedIn.add(city1);
        mutableEmployee1CitiesWorkedIn.add(city2);
        mutableEmployee1CitiesWorkedIn.add(city3);
        mutableEmployee1CitiesWorkedIn.add(city4);
        return mutableEmployee1CitiesWorkedIn;
    }

}
