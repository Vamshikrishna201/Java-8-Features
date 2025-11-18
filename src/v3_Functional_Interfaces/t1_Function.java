package v3_Functional_Interfaces;


import java.util.function.Function;

/* Function functional interface KeyPoints:-
- Function is pre-defined functional interface.
- It takes input and it returns output.
- Function interface having onw abstract method i.e `apply(T t)`
*/
public class t1_Function {
    public static void main(String[] args) {
        //function
        Function<Integer, String> f = (i) -> {
            return "Ram";
        };
        String apply = f.apply(100);
        System.out.println(apply);

        //example - 2
        Function<String, Integer> fun = (name) -> name.length();

        System.out.println(fun.apply("Fun"));
        System.out.println(fun.apply("To"));
        System.out.println(fun.apply("Learn, New Things"));

        //example - 3
        // WAP to take int array and return the sum of that array

        Function<int[], Integer> s = (i)->{
            int sum = 0;
            for(int a:i){
                sum +=a;
            }
            return sum;
        };
        int sum = s.apply(new int[] {1, 2, 3, 4, 5});
        System.out.println("Total Sum: " + sum);
    }
}
