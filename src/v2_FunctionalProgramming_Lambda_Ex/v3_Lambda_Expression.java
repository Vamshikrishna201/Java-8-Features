package v2_FunctionalProgramming_Lambda_Ex;

import java.util.Scanner;

@FunctionalInterface
interface Even {
    void isEven(int n);
}
// practice task ->
// 1. Create an interface CheckEven with method isEven(int n).
// 2. Use lambda to check whether n is even or odd.
// 3. Print the result.
public class v3_Lambda_Expression {
    public static void main(String[] args) {
        //input + finding v2_FunctionalProgramming_Lambda_Ex.Even numbers, if-else
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to Check even or odd: ");
        int i = sc.nextInt();

        Even e = (n) -> {
            if(i % 2 == 0){
                System.out.println("even");
            } else
                System.out.println("odd");
        };
        e.isEven(i);
    }
}
