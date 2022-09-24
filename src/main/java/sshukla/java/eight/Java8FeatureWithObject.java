package sshukla.java.eight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '22/09/2022'
 */
public class Java8FeatureWithObject {

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

        coursesListWithReviewScoreGreaterThan90UsingFilter(courseList, x -> x.getReviewScore() > 90);//stream(), filter()

        //allMatch(), noneMatch(), anyMatch()
        coursesUsingAllMatch(courseList, x -> x.getReviewScore() > 90);//stream(), allMatch()

        coursesUsingAllMatch(courseList, x -> x.getReviewScore() > 95);//stream(), allMatch()

        coursesUsingNoneMatch(courseList, x -> x.getReviewScore() > 90);//stream(), noneMatch()

        coursesUsingNoneMatch(courseList, x -> x.getReviewScore() > 95);//stream(), noneMatch()

        coursesUsingNoneMatch(courseList, x -> x.getReviewScore() < 90);//stream(), noneMatch()

        coursesUsingAnyMatch(courseList, x -> x.getReviewScore() > 90);//stream(), noneMatch()

        coursesUsingAnyMatch(courseList, x -> x.getReviewScore() > 95);//stream(), noneMatch()

        //sorted()
        Comparator<Course> CourseByASCNoOfStudentsComparator = Comparator.comparing(Course::getNoOfStudents);
        sortedCoursesUsingComparator(courseList, CourseByASCNoOfStudentsComparator);

        Comparator<Course> courseByDESCNoOfStudentsComparator = Comparator.comparing(Course::getNoOfStudents).reversed();
        sortedCoursesUsingComparator(courseList, courseByDESCNoOfStudentsComparator);

        Comparator<Course> coursesByDESCNoOfStudentAndASCReviewComparator = Comparator.comparing(Course::getNoOfStudents).reversed().thenComparing(Course::getReviewScore);
        sortedCoursesUsingComparator(courseList, coursesByDESCNoOfStudentAndASCReviewComparator);

        Comparator<Course> coursesByASCNoOfStudentAndDESCReviewComparator = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        sortedCoursesUsingComparator(courseList, coursesByASCNoOfStudentAndDESCReviewComparator);

        //sorted(), Comparator.comparingInt(), Comparator.thenComparingInt() - As above all four execution are specific to INT we should prefer Comparator.comparingInt() instead of Comparator.comparing() to ignore Boxing and Unboxing
        sortedCoursesUsingComparator(courseList, Comparator.comparingInt(Course::getNoOfStudents));

        sortedCoursesUsingComparator(courseList, Comparator.comparingInt(Course::getNoOfStudents).reversed());

        sortedCoursesUsingComparator(courseList, Comparator.comparing(Course::getNoOfStudents).reversed().thenComparing(Course::getReviewScore));

        sortedCoursesUsingComparator(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed());

        //sorted(), Comparator.comparingInt(), limit()
        sortedTopFiveCourses(courseList, Comparator.comparing(Course::getNoOfStudents));

        //sorted(), Comparator.comparingInt(), skip()
        skipTopThreeFromSortedCourses(courseList, Comparator.comparing(Course::getNoOfStudents));
        //sorted(), Comparator.comparingInt(), limit(), skip()
        skipTopThreeFromTopFiveSortedCourses(courseList, Comparator.comparing(Course::getNoOfStudents));

        //max()
        topCourseOnComparingNoOfStudentsAndNoOfReviewsDESC(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed());
    }

    private static void topCourseOnComparingNoOfStudentsAndNoOfReviewsDESC(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.topCourseOnComparingNoOfStudentsAndNoOfReviews()");
        Optional<Course> response = courseList.stream().max(courseComparator);
        System.out.println(response.get());
    }

    private static void skipTopThreeFromTopFiveSortedCourses(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.skipTopThreeFromSortedCourses()");
        List<Course> response = courseList.stream().sorted(courseComparator).limit(5).skip(3).collect(Collectors.toList());
        System.out.println(response);
    }

    private static void skipTopThreeFromSortedCourses(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.skipTopThreeFromSortedCourses()");
        List<Course> response = courseList.stream().sorted(courseComparator).skip(3).collect(Collectors.toList());
        System.out.println(response);
    }

    private static void sortedTopFiveCourses(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.sortedTopFiveCourses()");
        List<Course> response = courseList.stream().sorted(courseComparator).limit(5).collect(Collectors.toList());
        System.out.println(response);
    }

    private static void sortedCoursesUsingComparator(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.sortedCoursesUsingComparator()");
        List<Course> response = courseList.stream().sorted(courseComparator).collect(Collectors.toList());
        System.out.println(response);
    }

    private static void coursesUsingAnyMatch(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.coursesUsingAnyMatch()");
        boolean response = courseList.stream().anyMatch(coursePredicate);
        System.out.println(response);
    }

    private static void coursesUsingNoneMatch(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.coursesUsingNoneMatch()");
        boolean response = courseList.stream().noneMatch(coursePredicate);
        System.out.println(response);
    }

    private static void coursesUsingAllMatch(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.coursesUsingAllMatch()");
        boolean response = courseList.stream().allMatch(coursePredicate);
        System.out.println(response);
    }

    private static void coursesListWithReviewScoreGreaterThan90UsingFilter(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.coursesListWithReviewScoreGreaterThan90UsingFilter()");
        List<Course> response = courseList.stream().filter(coursePredicate).collect(Collectors.toList());
        System.out.println(response);
    }

}
