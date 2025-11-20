package v_6_Optional_Class;


import java.util.Optional;

// Practical mini-exercise (you type & run)
public class o1_Opt6 {
    public static Optional<String> findUsername(boolean found) {
        if (found) return Optional.of("devUser");
        else return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> u1 = findUsername(true);
        Optional<String> u2 = findUsername(true);

        System.out.println("u1: " + u1.orElse("guest"));
        System.out.println("u2: " + u2.orElseGet(() -> "guest-from-supplier"));

        u1.ifPresent(name -> System.out.println("u1 present: " + name));
        u2.ifPresentOrElse(
                name -> System.out.println("u2 present: " + name),
                () -> System.out.println("u2 is empty, fallback action")
        );

        //Do this: Change findUsername(true) to false and re-run.
        // See how outputs change.
        // This trains you to reason about present vs empty.
    }
}
