package v4_Method_Reference;

import java.util.function.Function;

// Static Method Reference - ( Example )
// When to use -> when your lambda is JUST calling a static method.

//syntax:
//ClassName::staticMethodName
public class m1_StaticMethRef{

    public static int square(int n){
        return n * n;
    }
    public static void main(String[] args) {
        // Without method reference
        Function<Integer, Integer> f1 = n -> m1_StaticMethRef.square(n);

        //With method reference
        Function<Integer, Integer> f2 = m1_StaticMethRef::square;

        System.out.println(f2.apply(5)); //25
    }
}