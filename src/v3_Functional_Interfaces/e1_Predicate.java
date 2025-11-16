package v3_Functional_Interfaces;

import java.util.function.Predicate;
/*
KEY POINTS:
---------
Predicate is a Functional interface.
it contains one abstract method that is, boolean test(T t);
Use to check condiation on an object and return a boolean result
 */
public class e1_Predicate {

    public static void main(String[] args) {
        //simple example:
        Predicate<Integer> salary = x -> x > 50000; // its like an if(x > 50000)
        System.out.println(salary.test(60000));


        //example:2 task is: print names in an array that start's with 'A' using lambda.
        String[] names = {"Arun", "Varun", "Ravi", "Arjun", "Avinash", "Dishant"};

        Predicate<String> p = name -> name.charAt(0) == 'A';

        for(String name : names){
            if(p.test(name)){
                System.out.println(name);
            }
        }

    }
}
