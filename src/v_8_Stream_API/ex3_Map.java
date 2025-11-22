package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;
/*
Map is an intermediate operation that transforms each element in the stream

Map is taking Function, Function will take the input and provide the output
 */
//Example - 1 - map()
public class ex3_Map {
    public static void main(String[] args) {
        //example:1 print names to uppercase from list of names
        List<String> names = Arrays.asList("india", "usa", "uk", "japan");

        names.stream().map( i -> i.toUpperCase() + " = " + i.length())
                .forEach(n -> System.out.println(n));


        //mapToInt converts a stream of objects to an IntStream
        // for efficient numeric operations like sum, average, min, or max.
        names.stream().mapToInt(name -> name.length())
                .forEach(n -> System.out.println(n));


        //example:2- print a square of all numbers from a list.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        numbers.stream().map( i -> i*i)
                .forEach(i -> System.out.println(i));

//      print square of even numbers only from a list of numbers
        numbers.stream()
                .filter( i -> i % 2==0 )
                .map(i -> i*i)
                .forEach(i -> System.out.print(i + " "));

    }
}
