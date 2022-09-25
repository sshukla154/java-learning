package sshukla.java.eight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class FindDuplicatesUsingStream {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        List<String> strings = Arrays.asList("Amanda", "Rob", "Sunny", "Amanda", "Rob");


        // Using Older version
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (Integer number : numbers) {
            integerMap.put(number, integerMap.get(number) != null ? integerMap.get(number) + 1 : 1);
        }
        System.out.println("Integer Output (Before Stream) - " + integerMap);

        Map<String, Integer> stringMap = new HashMap<>();
        for (String string : strings) {
            stringMap.put(string, stringMap.get(string) != null ? stringMap.get(string) + 1 : 1);
        }
        System.out.println("String Output (Before Stream) - " + stringMap);

        System.out.println("Integer Output (Using Stream) - " + numbers.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting())));
        System.out.println("String Output (Using Stream) - " + strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


    }

}
