package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;

// Task:- Print name its length which are starting with 'V' using Stream Api.
//example - 2 for map()
public class ex4_Stream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vamshikrishna", "Varun", "Rushi", "Vardhan", "Tushar");

        names.stream()
                .filter( i -> i.startsWith("V"))
                .map(name -> name + " - " + name.length())
                .forEach(p -> System.out.println(p));

    }
}
