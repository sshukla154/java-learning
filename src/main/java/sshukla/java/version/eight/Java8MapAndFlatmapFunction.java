package sshukla.java.version.eight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Java8MapAndFlatmapFunction {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("API", "Spring", "Spring Boot", "Java", "API", "MicroServices", "AWS", "PCF",
                "Azure", "Docker", "Java", "Kubernetes");

        getListOfAllCharactersFromListOfString(courses);

        getListOfDistinctCharactersFromListOfString(courses);

        getPairsOfSameLengthString(courses);

        getCharacterWithCount(courses);

    }

    private static void getPairsOfSameLengthString(List<String> courses) {
        System.out.println("Java8MapAndFlatmapFunction.getPairsOfSameLengthString()");
//        List<String[]> response = courses.stream().flatMap(course -> Arrays.asList(course))
//        System.out.println(response);
    }

    private static void getListOfDistinctCharactersFromListOfString(List<String> courses) {
        System.out.println("Java8MapAndFlatmapFunction.getCharacterWithCount()");
        List<String> response = courses.stream().map(x -> x.split("")).flatMap(Arrays::stream).distinct().sorted().collect(Collectors.toList());
        System.out.println(response);
    }

    private static void getCharacterWithCount(List<String> courses) {
        System.out.println("Java8MapAndFlatmapFunction.getCharacterWithCount()");
        Map<String, Long> response = courses.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(response);
    }

    private static void getListOfAllCharactersFromListOfString(List<String> courses) {
        System.out.println("Java8MapAndFlatmapFunction.getListOfCharacterFromListOfString()");
        List<String[]> incorrectResponse = courses.stream().map(x -> x.split("")).collect(Collectors.toList());
        System.out.println("Incorrect : " + incorrectResponse);

        List<String> correctResponse = courses.stream().map(x -> x.split("")).flatMap(Java8MapAndFlatmapFunction::apply).collect(Collectors.toList());
        System.out.println("Correct : " + correctResponse);

    }

    private static Stream<String> apply(String[] x) {
        return Arrays.stream(x);
    }
}
