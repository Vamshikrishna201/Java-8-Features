package v4_Method_Reference;


// Instance Method of a Special Object Reference
// When to use -> When you already have an object and the lambda calls its method.

// syntax:
// object::instanceMethodName

import java.util.function.Supplier;

public class m2_RefToInstanceMethod {

    public static void main(String[] args) {
        String name = "Vamshi";

        //Without method reference
        Supplier<Integer> s1 = () -> name.length();

        //With method reference
        Supplier<Integer> s2 = name::length;
        System.out.println(s2.get());

        //example-2
        String msg = "Hello";
        Supplier<Integer> s = msg::length;
        System.out.println(s.get()); // 5
    }
}
