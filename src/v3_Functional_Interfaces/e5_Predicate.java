package v3_Functional_Interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;


// BiPredicate Example
public class e5_Predicate {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i > 10;
        System.out.println(p.test(4));
        System.out.println(p.test(14));

        System.out.println("-=-=-=-=-=-=-=-=-=");

        BiPredicate<Integer, Integer> bip = (i, j) -> (i + j) >= 20;
        System.out.println(bip.test(2,2));
        System.out.println(bip.test(25,5));

    }
}
