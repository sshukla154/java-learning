package sshukla.java.version.eight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Java8FeatureWithString {

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("API", "Spring", "Spring Boot", "Java", "API", "MicroServices", "AWS", "PCF",
                "Azure", "Docker", "Java", "Kubernetes");

        printAllCourses(courses);//stream(), forEach()

        printAllCoursesContainingSpring(courses); //stream(), filter(), forEach()

        printAllCoursesNameHasAtLeast4Characters(courses); //stream(), filter(), forEach()

        printCoursesNameAndLengthAsMap(courses); //stream(), map(), collect(), forEach()

        coursesInAlphabeticalOrderSorting(courses); // stream(), sorted(), forEach()

        coursesInReverseOrderSorting(courses); // stream(), sorted(Comparator.reverseOrder()), forEach() -- Custom Sorting in reverse order

        coursesDistinctInReverseOrderSorting(courses); // stream(), distinct(), sorted(Comparator.reverseOrder()), forEach() -- Custom Sorting in reverse order

        coursesDistinctInReverseOrderSortingHavingCustomComparator(courses); // stream(), distinct(), sorted(Comparator.comparing(x -> x.length()))), forEach() -- Custom Comparator (e.g. comparing the length of string)

        listOfLengthOfCoursesTitle(courses); //stream(), map(), collect(Collectors.toList())

        getStringFromList(courses);//collect(Collectors.joining(", "));

    }

    private static void getStringFromList(List<String> courses) {
        System.out.println("Java8StringJoiner.getStringFromList()");
        StringJoiner stringJoiner = new StringJoiner(", ");
        String response = courses.stream().map(stringJoiner::add).toString();
        System.out.println("Incorrect Approach : " + response);

        response = courses.stream().collect(Collectors.joining(", "));
        System.out.println("Correct Approach : " + response);
    }

    private static void listOfLengthOfCoursesTitle(List<String> courses) {
        System.out.println("Java8FeatureWithString.listOfLengthOfCoursesTitle()");
        System.out.println(courses.stream().map(x -> x.length()).collect(Collectors.toList()));
    }

    private static void coursesDistinctInReverseOrderSortingHavingCustomComparator(List<String> courses) {
        System.out.println("Java8FeatureWithString.coursesDistinctInReverseOrderSortingHavingCustomComparator()");
        courses.stream().distinct().sorted(Comparator.comparing(x -> x.length())).forEach(Java8FeatureWithString::printCourses);
    }

    private static void coursesDistinctInReverseOrderSorting(List<String> courses) {
        System.out.println("Java8FeatureWithString.coursesDistinctInReverseOrderSorting()");
        courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(Java8FeatureWithString::printCourses);
    }

    private static void coursesInReverseOrderSorting(List<String> courses) {
        System.out.println("Java8FeatureWithString.coursesInReverseOrderSorting()");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(Java8FeatureWithString::printCourses);
    }

    private static void coursesInAlphabeticalOrderSorting(List<String> courses) {
        System.out.println("Java8FeatureWithString.coursesInAlphabeticalOrderSorting()");
        courses.stream().sorted().forEach(Java8FeatureWithString::printCourses);
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
        System.out.println("Java8FeatureWithString.printAllCoursesNameHasAtLeast4Characters()");
        courses.stream().filter(x -> x.length() >= 4).forEach(Java8FeatureWithString::printCourses);
    }

    private static void printAllCoursesContainingSpring(List<String> courses) {
        System.out.println("Java8FeatureWithString.printAllCoursesContainingSpring()");
        courses.stream().filter(x -> x.contains("Spring")).forEach(Java8FeatureWithString::printCourses);
    }

    private static void printAllCourses(List<String> courses) {
        System.out.println("Java8FeatureWithString.printAllCourses()");
        courses.stream().forEach(Java8FeatureWithString::printCourses);
    }

    private static void printCourses(String course) {
        System.out.println(course);
    }

}
