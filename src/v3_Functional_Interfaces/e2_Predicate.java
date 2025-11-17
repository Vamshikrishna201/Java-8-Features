package v3_Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
KEY POINTS:
---------
Predicate is a Functional interface.
it contains one abstract method that is, boolean test(T t);
Use to check condiation on an object and return a boolean result
*/
public class e2_Predicate {
    public static void main(String[] args) {
        //example-3
        List<Integer> list = Arrays.asList(4, 6, 2, 8, 2, 5, 8, 9, 2);
        Predicate<Integer> isEven = x -> x % 2 == 0;

        for(Integer i : list){
            if(isEven.test(i))
                System.out.print("Even:" + i + ", ");
        }

        //example-4 : checking the word starting with 'V' or not!
        Predicate<String> checkChar = c -> c.toLowerCase().charAt(0) == 'v';
        System.out.println(checkChar.test("Vamsi"));


    }
}

