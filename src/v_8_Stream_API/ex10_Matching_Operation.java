package v_8_Stream_API;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Person {
    String name;
    String country;

    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
public class ex10_Matching_Operation {
    public static void main(String[] args) {

        Person p1 = new Person("John", "USA");
        Person p2 = new Person("Steven", "JAPAN");
        Person p3 = new Person("Vamshikrishna", "INDIA");
        Person p4 = new Person("Ching", "CHINA");
        Person p5 = new Person("Ashok", "INDIA");

        List<Person> persons = Arrays.asList(p1,p2,p3,p4);

        boolean status1 = persons.stream().anyMatch( i -> i.country.equals("INDIA"));
        System.out.println("Any Indian Available in Company: " + status1); //true

        boolean status2 = persons.stream().anyMatch( i -> i.country.equals("CANADA"));
        System.out.println("Any Canadian Available in Company: " + status2); //false

        boolean status3 = persons.stream().allMatch( i -> i.country.equals("CANADA"));
        System.out.println("All Persons from INDIA: " + status3); //false

        boolean status4 = persons.stream().noneMatch( i -> i.country.equals("MAXICO"));
        System.out.println("No Persons from Mexico? " + status4); //true
    }
}