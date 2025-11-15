package v2_FunctionalProgramming_Lambda_Ex;

import java.util.ArrayList;
import java.util.Locale;
//Practice Task:- with forEach (collections)
//Create a List of names.
//Using forEach() with lambda to print each name in uppercase.
public class v4_Lambda_Expression {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("krishna");
        l.add("arjun");
        l.add("karan");

        l.forEach( a -> {
            char firstChar = a.charAt(0);
            String capitalFirstChar = String.valueOf(firstChar).toUpperCase();
            String restOfString = a.substring(1);
            System.out.println(capitalFirstChar+restOfString);
        });
        /*
        charAt()      -  Returns the character at a specific index in a string.
        valueOf()     -  Converts any data_type value into a String.
        substring()   -  Extracts a portion of a string between given indices.
        toUpperCase() - Converts all letters in a string to uppercase.
         */
    }
}
