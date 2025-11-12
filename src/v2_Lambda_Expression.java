
// Functional interface – contains only one abstract method
interface Calc {
    void calculate(int a, int b);
}

// Without Lambda Expression (Old Way – Before Java 8)
class Addition implements Calc {
    // Implementing the interface method manually
    public void calculate(int a, int b) {
        // Without parentheses -> 2 + 4 = 24 (wrong)
        // With parentheses -> correct arithmetic
        System.out.println("Addition: " + a + " + " + b + " = " + (a + b));
    }
}
//and also u can create several classes like
//Subraction-, Devission / etc....
public class v2_Lambda_Expression {
    public static void main(String[] args) {
        // 1. Traditional approach (Before Java 8)
        Calc c1 = new Addition();// Create object of concrete class
        c1.calculate(2, 4); // Call method using object

        // 2. Lambda Expression (Java 8+)
        // We don’t need a separate class; we just provide the behavior directly.
        Calc c2 = (a, b) -> System.out.println("Addition: " + a + " + " + b + " = " + (a + b));
        Calc c3 = (a,  b) -> System.out.println("Multiplication: " + a + " x " + b + " = " + (a * b));
        Calc c4 = (a,  b) -> System.out.println("Devision: " + a + " / " + b + " = " + (a / b));
        c2.calculate(2, 4); // Call lambda implementation
        c3.calculate(22, 4);
        c4.calculate(26, 4);
    }
}
