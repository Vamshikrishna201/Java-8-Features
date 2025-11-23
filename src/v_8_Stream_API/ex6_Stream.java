package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// flatMap() example-1
public class ex6_Stream {
    public static void main(String[] args) {
        // flatMap() -> it will flaten your List, it will make single collection
        List<String> javaCourses = Arrays.asList("Core-Java", "Adv-Java", "Springboot"); //1st collection
        List<String> uiCourses = Arrays.asList("HTML", "CSS", "JavaScript", "BootStrap"); //2nd collection

        List<List<String>> courses = Arrays.asList(javaCourses, uiCourses);//List of Lists

//        courses.forEach( c -> System.out.println(c));

        Stream<String> flatMap = courses.stream()
                .flatMap(s -> s.stream());
        // it is use to multiple collection in to 1 collection


        flatMap.forEach( c -> System.out.println(c));
    }
}