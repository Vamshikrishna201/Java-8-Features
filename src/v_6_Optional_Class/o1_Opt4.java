package v_6_Optional_Class;


import java.util.Optional;

// Compare orElse vs orElseGet (important pitfall)
public class o1_Opt4 {

    public static String heavyFallback() {
        System.out.println("heavyFallback() called");
        return "HeavyDefault";
    }

    public static void main(String[] args) {
        // Compare orElse vs orElseGet (important pitfall)
        Optional<String> opt = Optional.of("RealValue");

        // orElse ALWAYS calls the method/argument even if Optional is present
        String a = opt.orElse(heavyFallback());
        System.out.println("orElse returned: " + a);

        // orElseGet calls supplier only when empty
        String b = opt.orElseGet(() -> heavyFallback());
        System.out.println("orElseGet returned: " + b);

        //What it demonstrates: orElse evaluates argument even when not needed;
        // orElseGet is lazy.

        // Why: heavyFallback() prints when orElse was evaluated.
        // This is why prefer orElseGet for expensive defaults.
    }
}
