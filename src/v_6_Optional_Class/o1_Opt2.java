package v_6_Optional_Class;

import java.util.Optional;

public class o1_Opt2 {
    public static void main(String[] args) {
        //Optional.ofNullable() — safe when value may be null

        String maybe = null; // change to "Hello" later and re-run
        Optional<String> opt = Optional.ofNullable(maybe);

        System.out.println("isPresent: " + opt.isPresent()); //return boolean

        // If the Optional is empty, no action is performed.
        opt.ifPresent(v -> System.out.println("value ifPresent: " + v));

        //if value is null, ofNullable() its gives you an empty box, -> Optional.empty
        //is value is present then ofNullable(), gives u optional containing that value
        System.out.println("toString: " + opt);
    }
}
