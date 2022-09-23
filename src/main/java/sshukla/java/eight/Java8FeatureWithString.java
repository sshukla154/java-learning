package sshukla.java.eight;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Java8FeatureWithString {

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("API", "Spring", "Spring Boot", "Java", "API", "MicroServices", "AWS", "PCF",
                "Azure", "Docker", "Java", "Kubernetes");

        printAllCourses(courses);

        printAllCoursesContainingSpring(courses);

        printAllCoursesNameHasAtLeast4Characters(courses);

        printCoursesNameAndLengthAsMap(courses);

    }

    private static void printCoursesNameAndLengthAsMap(List<String> courses) {
        System.out.println("Java8FeatureWithString.printCoursesNameAndLengthAsMap()");
        Map<String, Integer> map = new LinkedHashMap<>();
        courses.stream()
                .map(x -> map.put(x, x.length()))
                .collect(Collectors.toList());
        map.keySet().forEach(x -> System.out.println(x + " : " + map.get(x)));

    }

    private static void printAllCoursesNameHasAtLeast4Characters(List<String> courses) {
        System.out.println("Java8FeatureWithString.printAllCoursesContainingSpring()");
        courses.stream().filter(x -> x.length() >= 4).forEach(Java8FeatureWithString::printCourses);
    }

    private static void printAllCoursesContainingSpring(List<String> courses) {
        System.out.println("Java8FeatureWithString.printAllCoursesContainingSpring()");
        courses.stream().filter(x -> x.contains("Spring")).forEach(Java8FeatureWithString::printCourses);
    }

    private static void printAllCourses(List<String> courses) {
        System.out.println("Java8FeatureWithString.printAllOddNumbersUsingLambdaExpression()");
        courses.stream().forEach(Java8FeatureWithString::printCourses);
    }

    private static void printCourses(String course) {
        System.out.println(course);
    }

}
