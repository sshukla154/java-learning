package sshukla.java.generics;

/**
 * @author 'Seemant Shukla' on '19/09/2022'
 */
public class GenericsClient {

    public static void main(String[] args) {

        //Without Generics - Creating 3 different classes
        IntegerPrinter integerPrinter = new IntegerPrinter(10);
        DoublePrinter doublePrinter = new DoublePrinter(10.00);
        StringPrinter stringPrinter = new StringPrinter("Hello World!!!");

        integerPrinter.print();
        doublePrinter.print();
        stringPrinter.print();

        //With Generics - Using same class (i.e Type)
        GenericsPrinter<Integer> genericIntegerPrinter = new GenericsPrinter<>(100);
        GenericsPrinter<Double> genericDoublePrinter = new GenericsPrinter<>(100.00);
        GenericsPrinter<String> genericStringPrinter = new GenericsPrinter<>("Generic - Hello World!!!");

        genericIntegerPrinter.print();
        genericDoublePrinter.print();
        genericStringPrinter.print();

        //With Bounded Generics - Using same class (i.e. Type) which extends a specific class or implements a specific interface
        BoundedGenericsPrinter<Cat> boundedGenericCatPrinter = new BoundedGenericsPrinter<>(new Cat("Blacky"));
        boundedGenericCatPrinter.print();
        BoundedGenericsPrinter<Dog> boundedGenericDogPrinter = new BoundedGenericsPrinter<>(new Dog("Lucy"));
        boundedGenericDogPrinter.print();


//        BoundedGenericsPrinter<Integer> boundedGenericIntegerPrinter = new BoundedGenericsPrinter<>(123);

        //Generics on Methods - Single params
        singleParams("Hello-World");
        singleParams(123);

        //Generics on Methods - Multi params
        multiParams("Hello", "World");
        multiParams("Hello-World", -123);

        // Generics - ReturnType as Generic
        GenericsAsReturnTypePrinter<String> stringGenericsAsReturnTypePrinter = new GenericsAsReturnTypePrinter<>("Hi...");
        String stringInputToPrint = stringGenericsAsReturnTypePrinter.print("Hi...");
        System.out.println("String-Input-To-Print : " + stringInputToPrint);

        GenericsAsReturnTypePrinter<Integer> integerGenericsAsReturnTypePrinter = new GenericsAsReturnTypePrinter<>(123321);
        Integer integerInputToPrint = integerGenericsAsReturnTypePrinter.print(123321);
        System.out.println("Integer-Input-To-Print : " + integerInputToPrint);


    }

    //Generics on Methods - Single params
    private static <T> void singleParams(T singleParamInput) {
        System.out.println(singleParamInput + " !!!!!");
    }

    //Generics on Methods - Multi params
    private static <T1, T2> void multiParams(T1 singleParamInput1, T2 singleParamInput2) {
        System.out.println(singleParamInput1 + " !!!!!, " + singleParamInput2 + " !!!!!");
    }

}
