package v_6_Optional_Class;

import java.util.Optional;
import java.util.Scanner;

public class b2_msgServer2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter User ID");
        int userId = s.nextInt();

        b1_User u = new b1_User(); //user Obj created
//        String userName = u.getUserNameById(userId);

        Optional<String> username = u.getUsername(userId);

        if(username.isPresent()){ //isPresent() checks, null or not and return boolean
            String name = username.get();
            // .get(), if Optional obj contains non-null value it returns the value
            // if Optional object dose no contain a value, get.() will throw a NoSuchElementException.
            System.out.println(name.toUpperCase() + ", Hello");
        } else {
            System.out.println("No data found");
        }
    }
}
