package v3_Functional_Interfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/*
Supplier Keypoints:-

- Supplier is functional interface
- it's contains only single abstract method, T get();
- Supplier will just provide output without any input.
*/
public class s1_Supplier {
    public static void main(String[] args) {
        // simple example-1
        Supplier<Integer> s = () -> 100;
        System.out.println(s.get());

        //example - 2;
        Supplier<String> v = () ->{
            return "Vamshi".toUpperCase();
        };
        System.out.println(v.get());

        //example - 3;
        Supplier<int[]> a = () ->{
            return new int[] {1,2,3,4,5};
        };
                        //i<5
        for(int i=0; i<a.get().length; i++){
            System.out.println(a.get()[i]);
        }

        // example - 4
        Supplier<LocalDateTime> currentTime =  () -> LocalDateTime.now();
        System.out.println("Current Date and Time: "+ currentTime.get());
    }
}
