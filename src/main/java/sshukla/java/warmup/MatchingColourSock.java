package sshukla.java.warmup;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class MatchingColourSock {

    public static void main(String[] args) {

        System.out.println(sockMerchant(List.of(1, 2, 1, 2, 1, 3, 2)));//2 (1,1,2,2)

        System.out.println(sockMerchant(List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));//3 (10, 10, 20)

    }

    public static int sockMerchant(List<Integer> input) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Integer i : input) {
            linkedHashMap.put(i, linkedHashMap.get(i) != null ? linkedHashMap.get(i) + 1 : 1);
        }

//        linkedHashMap.keySet().stream().filter(i -> linkedHashMap.get(i) >= 2).forEach(x -> System.out.println(x + " : " + linkedHashMap.get(x)));

        return linkedHashMap.keySet().stream()
                .filter(i -> linkedHashMap.get(i) >= 2)
                .map(i -> linkedHashMap.get(i) / 2)
                .reduce(0, Integer::sum);

    }
}
