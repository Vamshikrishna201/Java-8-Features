package v3_Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/*
KeyPoints:- Consumer.
- Consumer is a pre-defined functional interface in java.util.function package.
- It contains one abstract method i.e accept(T t)
- Consumer will accept input but return's nothing.

Consumer -----> take's input -----> return's Nothing.
*/
public class f2_Consumer {
    public static void main(String[] args) {
        //example - 1
        Consumer<Integer> c = (i) -> System.out.println(i + i);
        c.accept(5);

        //example - 2
        Consumer<String> greetings  = i -> System.out.println("Hello " + i +"!");
        greetings.accept("Vamshi");
        greetings.accept("Jeevan");

        //example - 3
        Consumer<Integer> n = v -> System.out.println(v + " Square is: " + v*v);
        n.accept(45); // output: 2025 , (XD in year is also 2025 LoL)

        //example - 4
        Consumer<String[]> s = (i) -> {
            for(String w : i){
                System.out.println(w);
            }
        };
        String[] names = {"Apple", "Ball", "Cat", "Dog"};
        s.accept(names);

        //example - 5
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        Consumer<Integer> printNum = num -> System.out.println("Number: "+ num);
        System.out.println("Printing numbers from the list:");
        numbers.forEach(printNum);

    }
}
