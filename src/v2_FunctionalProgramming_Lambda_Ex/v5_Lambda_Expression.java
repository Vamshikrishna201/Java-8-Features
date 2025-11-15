package v2_FunctionalProgramming_Lambda_Ex;

import java.util.*;

//Practice tasl:- lambda with Comparator
//Create a List with random numbers
//Sort it in decending order using Collction.sort() with a lambda comparator.
//print the sorted list.
public class v5_Lambda_Expression {
    public static void main(String[] args) {
        List<Integer> v = new Vector<>();
        v.add(7);
        v.add(2);
        v.add(5);
        v.add(6);
        v.add(8);
        v.add(9);

        // Normal
        Collections.sort(v);
        System.out.println(v);

        // with Lambda
        v.sort((a, b) ->{
            if(a > b)
                return 1;
            else if(a < b)
                return -1;
            else return 0;
        });
        for(Integer i : v){
            System.out.print(i +" ");
        }
    }
}
