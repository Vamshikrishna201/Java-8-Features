package v3_Functional_Interfaces;

import java.util.function.Supplier;

public class s2_Supplier {
    public static void main(String[] args) {
        //Supplier example - 6;
        Supplier<String> s = () -> {
            String otp = "";
            for(int i=1; i<=5; i++){
                otp = otp + (int) (Math.random() * 10);
            }
            return otp;
        };
        System.out.println(s.get());
        System.out.println(s.get());
    }
}
