package sshukla.java.custom.arraylist;

/**
 * @author 'Seemant Shukla' on '09/10/2022'
 */
public class CustomArrayListClient {
    public static void main(String[] args) {
        CustomArrayListWithoutDuplicates customArrayListWithoutDuplicates = new CustomArrayListWithoutDuplicates();
        customArrayListWithoutDuplicates.add(1);
        customArrayListWithoutDuplicates.add(2);
        customArrayListWithoutDuplicates.add(3);
        customArrayListWithoutDuplicates.add(1);
        System.out.println(customArrayListWithoutDuplicates);
    }
}
