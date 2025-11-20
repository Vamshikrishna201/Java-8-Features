package v_6_Optional_Class;

import java.util.Optional;

public class o1_Opt1 {
    public static void main(String[] args) {
        String name = "Vamshi";
        Optional<String> opt = Optional.of(name); // you are certain name != null

        // get() is safe here because we used of() with non-null
        System.out.println("hasValue: " + opt.isPresent()); //true
        System.out.println("value: " + opt.get()); //Vamshi

        //-------------------------------------------

        String name1 = null;
        Optional<String> o = Optional.of(name1);
        // THIS WILL THROW NullPointerException
        System.out.println(o);
    }
}
