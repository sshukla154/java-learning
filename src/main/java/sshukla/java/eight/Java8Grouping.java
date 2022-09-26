package sshukla.java.eight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '24/09/2022'
 */
public class Java8Grouping {

    public static void main(String[] args) {
        List<Course> courseList = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("Fullstack", "Fullstack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        groupCoursesByCategory(courseList);

        groupCoursesByCategoryAndMaxOfNoOfStudent(courseList);

        groupCoursesByCategoryAndMaxOfReview(courseList);

        groupCoursesByCategoryAndCount(courseList);

        groupCoursesByCategoryAndMaxOfReviewed(courseList);

        groupCourseNameByCategory(courseList);

    }

    private static void groupCourseNameByCategory(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCourseNameByCategory()");
        Map<String, List<String>> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));
        System.out.println(response);
    }

    private static void groupCoursesByCategoryAndMaxOfReviewed(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCoursesByCategoryAndMaxOfReviewed()");
        Map<String, Optional<Course>> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore))));
        System.out.println(response);
    }

    private static void groupCoursesByCategoryAndCount(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCoursesByCategoryAndCount()");
        Map<String, Long> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(response);
    }

    private static void groupCoursesByCategoryAndMaxOfReview(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCoursesByCategoryAndMaxOfReview()");
        Map<String, Optional<Course>> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));
        System.out.println(response);
    }

    private static void groupCoursesByCategoryAndMaxOfNoOfStudent(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCoursesByCategoryAndMaxOfNoOfStudent()");
        Map<String, Optional<Course>> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getNoOfStudents))));
        System.out.println(response);
    }

    private static void groupCoursesByCategory(List<Course> courseList) {
        System.out.println("Java8GroupingExample.groupCoursesByCategory()");
        Map<Object, List<Course>> response = courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.toList()));
        System.out.println(response);
    }

}
