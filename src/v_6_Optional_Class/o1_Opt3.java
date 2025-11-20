package v_6_Optional_Class;

import java.util.Optional;

public class o1_Opt3 {
    public static void main(String[] args) {

        //Optional.empty() - explicit empty
        Optional<String> opt = Optional.empty();

        System.out.println("isPresent: " + opt.isPresent());
        System.out.println("orElse: " + opt.orElse("Default"));
    }
}