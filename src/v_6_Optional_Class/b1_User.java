package v_6_Optional_Class;

import java.util.Optional;
import java.util.Scanner;

public class b1_User {
    public String getUserNameById(Integer id) {
        String name = null;
        if(id == 100){
            return "Ram";
        }
        else if(id == 101) {
            return"Krishna";
        }
        else if(id == 103) {
            return "Hari";
        }
        return name;
    }
    //------------------------ Optional Object
    public Optional<String> getUsername(Integer id){
        String name = null;

        if(id == 100){
            name = "Ram";
        }
        else if(id == 101) {
            name = "Krishna";
        }
        else if(id == 102) {
            name = "Hari";
        }

        return Optional.ofNullable(name);//If name is null → produces an empty Optional.
    }
}
class MsgService {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter User ID");
        int userId = s.nextInt();

        b1_User u = new b1_User();
        String userName = u.getUserNameById(userId);

//      To avoid NullPointerExceptions we have to implement null check
//      before performing operation on the Object.
        if(userName != null) {
            String msg = userName.toUpperCase() + ", Hello";
            System.out.println(msg);
        }
        else{
            System.out.println("Invalid Id!");
        }
        // the problem is we cannot do to many null checks that make our code ugly
        // to fix that we have Optional class, instead null check.
    }
}
