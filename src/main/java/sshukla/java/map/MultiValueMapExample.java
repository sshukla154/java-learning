package sshukla.java.map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

/**
 * @author 'Seemant Shukla' on '13/10/2022'
 */
public class MultiValueMapExample {

    public static void main(String[] args) {
        MultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<>();
        linkedMultiValueMap.add("User", "Seemant, Golu");
        linkedMultiValueMap.add("Message", "Hello World!!!");

        System.out.println(linkedMultiValueMap);

        MultiValueMap<String, String> multiValueMapAdapter = new MultiValueMapAdapter<>(linkedMultiValueMap);
        System.out.println(multiValueMapAdapter);

    }

}
