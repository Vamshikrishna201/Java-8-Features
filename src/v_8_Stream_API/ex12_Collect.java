package v_8_Stream_API;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//If any INDIAN Person Available the get the Person data
//-> Collectors are used to collect the data from the stream
//using Collectors.toList() -> this will give result in List
public class ex12_Collect {
    public static void main(String[] args) {
        Person p1 = new Person("John", "USA");
        Person p2 = new Person("Steven", "JAPAN");
        Person p3 = new Person("Vamshikrishna", "INDIA");
        Person p4 = new Person("Ching", "CHINA");
        Person p5 = new Person("Ashok", "INDIA");

        List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5);

        List<String> indians = persons.stream()
                .filter( i -> i.country.equals("INDIA"))
                .map(i -> i.name)
                .collect(Collectors.toList());

        System.out.println(indians);
    }
}
