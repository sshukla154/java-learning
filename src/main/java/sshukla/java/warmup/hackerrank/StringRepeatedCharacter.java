package sshukla.java.warmup.hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 'Seemant Shukla' on '21/09/2022'
 */
public class StringRepeatedCharacter {

    public static void main(String[] args) {
        System.out.println(convertStringIntoStringOfKeyWithValue("aaaccccccccbbbbb")); //Expected output 3a8c5b
        System.out.println(convertStringIntoStringOfKeyWithValue(""));
    }

    public static String convertStringIntoStringOfKeyWithValue(String input){
        Map<String, Integer> outputMap = new LinkedHashMap<>();
        for(String str : input.split("")){
            outputMap.put(str, outputMap.get(str) != null ? (outputMap.get(str) + 1 ) : 1);
        }
        StringJoiner output = new StringJoiner("");
        outputMap.keySet().forEach(x -> output.add(outputMap.get(x) + "" + x));
        return output.toString();

    }
}
