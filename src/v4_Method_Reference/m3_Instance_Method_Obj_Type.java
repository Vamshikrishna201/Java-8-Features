package v4_Method_Reference;

import java.util.function.Predicate;

//Instance Method of an object of a Type - ClassName::method

//When to use? -> When the first argument of the lambda becomes the calling object.
public class m3_Instance_Method_Obj_Type {
    public static void main(String[] args) {
        // Without method reference
        Predicate<String> p1 = str -> str.isEmpty();

        // With method reference
        Predicate<String> p2 = String::isEmpty;
        System.out.println(p2.test("")); //true

        System.out.println("Hi"); //false

        // Here the String passed ti test() becomes the object for isEmpty().

    }
}
