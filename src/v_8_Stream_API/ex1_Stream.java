package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ex1_Stream {
    public static void main(String[] args) {
        // 2 ways to create Stream in java...

//      1) stream.of() method
//      when to use:-
//      Stream.of() is for creating a stream directly from given values when you don’t have a collection.
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6);

        Stream<Integer> filter = stream1.filter((p) -> p % 2==0);

        filter.forEach((i)-> System.out.println(i));

        //---------------------------------------------

//      2) stream() method
//      when to use:-
//      stream() is for when you already have a Collection and want a stream from its elements.
        List<Integer> list = Arrays.asList(7,8,9,10,11,12,13);

        Stream<Integer> stream = list.stream();

        stream.filter(i -> i % 2==0)
                .forEach(i -> System.out.println(i));

        //------------------------------------------------

        //Task:- Create a list of names and print the names which starts with V, using stream api.
        List<String> names = Arrays.asList("Vamshi", "Varun", "Vipul", "Anushka", "Shree", "Prasad");

        names.stream().filter( i -> i.startsWith("V")).forEach( i -> System.out.println(i));

        //------------------------------------

        //Task:- print names whose name is grater then 4 characters.
        String[] names1 = {"Vamshi", "Om",
                "Aadi", "Ravi",
                "Vijay", "jayshri"};
        Stream<String> str = Stream.of(names1);

        str.filter(i -> i.length() > 4)
                .forEach(i->System.out.println(i));

    }
}
