package sshukla.java.eight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        //sorted()HHT
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
        maxCourseOnComparingNoOfStudentsAndNoOfReviews(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore));

        //min()
        minCourseOnComparingNoOfStudentsAndNoOfReviews(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore));

        //max()
        maxCourseOnComparingNoOfStudentsAndNoOfReviews(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed());

        //min()
        minCourseOnComparingNoOfStudentsAndNoOfReviews(courseList, Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed());

        //filter(), findAny()
        findAnyFromSortedCoursesUsingFilter(courseList, x -> x.getReviewScore() > 90);

        //filter(), findAny()
        findAnyFromSortedCoursesUsingFilter(courseList, x -> x.getReviewScore() > 100);

        //filter(), findFirst()
        findFirstFromSortedCoursesUsingFilter(courseList, x -> x.getReviewScore() > 92);

        // Find total no of students, which has review greater than 95
        findTotalNoOfStudentOfReviewGreaterThan95(courseList, x -> x.getReviewScore() > 95);

        // Find total no of students, which has review greater than 95
        findAverageNoOfStudentOfReviewGreaterThan95(courseList, x -> x.getReviewScore() > 95);

        // Find count of such courses, which has review greater than 95
        findCountOfNoOfStudentOfReviewGreaterThan95(courseList, x -> x.getReviewScore() > 95);

        findMaxOfNoOfStudentOfReviewGreaterThan95(courseList, x -> x.getReviewScore() > 95);

        findMinOfNoOfStudentOfReviewGreaterThan95(courseList, x -> x.getReviewScore() > 95);

    }

    private static void findMinOfNoOfStudentOfReviewGreaterThan95(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findMinOfNoOfStudentOfReviewGreaterThan95()");
        int totalNoOfStudents = courseList.stream().filter(coursePredicate).mapToInt(Course::getNoOfStudents).min().orElse(0);
        System.out.println(totalNoOfStudents);
    }

    private static void findMaxOfNoOfStudentOfReviewGreaterThan95(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findMaxOfNoOfStudentOfReviewGreaterThan95()");
        int totalNoOfStudents = courseList.stream().filter(coursePredicate).mapToInt(Course::getNoOfStudents).max().orElse(0);
        System.out.println(totalNoOfStudents);
    }

    private static void findCountOfNoOfStudentOfReviewGreaterThan95(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findCountOfNoOfStudentOfReviewGreaterThan95()");
        long totalNoOfStudents = courseList.stream().filter(coursePredicate).mapToInt(Course::getNoOfStudents).count();
        System.out.println(totalNoOfStudents);
    }

    private static void findAverageNoOfStudentOfReviewGreaterThan95(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findAverageNoOfStudentOfReviewGreaterThan95()");
        double totalNoOfStudents = courseList.stream().filter(coursePredicate).mapToInt(Course::getNoOfStudents).average().orElse(0);
        System.out.println(totalNoOfStudents);
    }

    private static void findTotalNoOfStudentOfReviewGreaterThan95(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findTotalNoOfStudentOfReviewGreaterThan95()");
        Integer totalNoOfStudents = courseList.stream().filter(coursePredicate).map(Course::getNoOfStudents).reduce(0, Integer::sum);
        System.out.println(totalNoOfStudents);
        totalNoOfStudents = courseList.stream().filter(coursePredicate).mapToInt(Course::getNoOfStudents).sum();
        System.out.println(totalNoOfStudents);
    }

    private static void findFirstFromSortedCoursesUsingFilter(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findAnyFromSortedCoursesUsingFilter()");
        Course response = courseList.stream().filter(coursePredicate).findFirst().orElse(new Course("Backup Course", "IT", 100, 100));
        System.out.println(response);
    }

    private static void findAnyFromSortedCoursesUsingFilter(List<Course> courseList, Predicate<Course> coursePredicate) {
        System.out.println("Java8FeatureWithObject.findAnyFromSortedCoursesUsingFilter()");
        Course response = courseList.stream().filter(coursePredicate).findAny().orElse(new Course("Backup Course", "IT", 100, 100));
        System.out.println(response);
    }

    private static void minCourseOnComparingNoOfStudentsAndNoOfReviews(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.topCourseOnComparingNoOfStudentsAndNoOfReviews()");
        Course response = courseList.stream().min(courseComparator).orElse(new Course("Backup Course", "IT", 100, 100));
        System.out.println(response);
    }

    private static void maxCourseOnComparingNoOfStudentsAndNoOfReviews(List<Course> courseList, Comparator<Course> courseComparator) {
        System.out.println("Java8FeatureWithObject.topCourseOnComparingNoOfStudentsAndNoOfReviews()");
        Course response = courseList.stream().max(courseComparator).orElse(new Course("Backup Course", "IT", 100, 100));
        System.out.println(response);
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
