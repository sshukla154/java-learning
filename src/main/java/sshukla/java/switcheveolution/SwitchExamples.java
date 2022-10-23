package sshukla.java.switcheveolution;

import java.util.Random;

/**
 * @author 'Seemant Shukla' on '21/10/2022'
 */
public class SwitchExamples {

    public static void main(String[] args) {

        java6TraditionalSwitch(new Random().nextInt(7));

        java7TraditionalSwitchWithStrings("");

        java14TraditionalSwitchWithConstantList(Weekdays.SUNDAY);

        System.out.println(java14SwitchExpressionWithYield(Operation.ADDITION, new Random().nextInt(10), new Random().nextInt(1000)));

        java14SwitchExpressionWithArrowCase(Weekdays.SUNDAY);

        java14SwitchExpressionWithConstantList(Weekdays.SUNDAY);

//        java17SwitchExpressionWithPatternMatching("String");

//        java17SwitchExpressionWithGuardedPattern("youlearncode@code.com");

    }

    private static void java17SwitchExpressionWithGuardedPattern(Object email) {
        switch (email) {
            case String s && s.contains("@") && s.length() > 8 -> login();
            case null -> throw new IllegalArgumentException();
            default -> System.out.println("Please enter a valid e-mail.");
        }
    }

    private static void login() {
        System.out.println("Registration successful!");
    }


    private static void java17SwitchExpressionWithPatternMatching(Object obj) {
        switch (obj) {
            // Uncommenting will cause the switch to fail since everything falls into Object.
            //case Object o -> System.out.println(o);
            case String str -> System.out.println(str);
            case Integer i -> System.out.println(i);
            case Double d -> System.out.println(d);
            case Boolean b -> System.out.println(b);
            case Weekdays weekday -> System.out.println(weekday);
            case null -> System.out.println("It's " + null); // Literal to avoid ambiguity.
            default -> System.out.println("Not an expected type!");
        }
        ;
    }

    private static void java14SwitchExpressionWithConstantList(Weekdays weekday) {
        switch (weekday) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Workday");
            case SATURDAY, SUNDAY -> System.out.println("Weekend");
        }
    }

    private static void java14SwitchExpressionWithArrowCase(Weekdays weekday) {
        switch (weekday) {
            case SUNDAY -> System.out.println(Weekdays.SUNDAY);
            case MONDAY -> System.out.println(Weekdays.MONDAY);
            case TUESDAY -> System.out.println(Weekdays.TUESDAY);
            case WEDNESDAY -> System.out.println(Weekdays.WEDNESDAY);
            case THURSDAY -> System.out.println(Weekdays.THURSDAY);
            case FRIDAY -> System.out.println(Weekdays.FRIDAY);
            case SATURDAY -> System.out.println(Weekdays.SATURDAY);
        }
    }

    private static int java14SwitchExpressionWithYield(Operation operation, int num1, int num2) {
        return switch (operation) {
            case ADDITION:
                yield num1 + num2;
            case SUBTRACTION:
                yield num1 - num2;
            case MULTIPLICATION:
                yield num1 * num2;
            case DIVISION:
                yield num1 / num2;
        };
    }

    private static void java14TraditionalSwitchWithConstantList(Weekdays weekday) {
        switch (weekday) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                System.out.println("Workday");
                break;
            case SATURDAY, SUNDAY:
                System.out.println("Weekend");
                break;
        }
    }

    private static void java7TraditionalSwitchWithStrings(String weekday) {
        switch (weekday) {
            case "Sun":
                System.out.println("Sunday");
                break;
            case "Mon":
                System.out.println("Monday");
                break;
            case "Tue":
                System.out.println("Tuesday");
                break;
            case "Wed":
                System.out.println("Wednesday");
                break;
            case "Thu":
                System.out.println("Thursday");
                break;
            case "Fri":
                System.out.println("Friday");
                break;
            case "Sat":
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Not a day!");
        }
    }

    // Traditional Switch Statement
    private static void java6TraditionalSwitch(int day) {
        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Not a day");
        }
    }

}

enum Weekdays {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum Operation {
    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
}
