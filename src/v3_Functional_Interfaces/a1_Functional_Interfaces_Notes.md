### ⚙️ Common Built-in Functional Interfaces

-> In java 8 several predefined Functional interfaces got introduces they are:

| Interface           | Package                 | Method                  | Purpose                   |
|---------------------|-------------------------|-------------------------|---------------------------|
| `Predicate<T>`      | `java.util.function`    | `boolean test(T t)`     | Returns boolean           |
| `Function<T,R>`     | `java.util.function`    | `R apply(T t)`          | Returns a transformed value |
| `Consumer<T>`       | `java.util.function`    | `void accept(T t)`      | Performs an action (no return) |
| `Supplier<T>`       | `java.util.function`    | `T get()`               | Supplies a value (no input) |

-> These interfaces are in the `java.util.function` package.

**1) Predicate:-**
- It is predefined Functional interface.
- It is used check condition and returns `boolean` value.
- Predicate interface having only one abstract method that is `boolean test(T t);`
- Use when you need true/false checks (filtering, validation).

*Example:-*
```java
public class PredicateDemo {
//      without Predicate
//    public boolean test(int i ) {
//        if(i > 10){
//            return true;
//        } else {
//            return false;
//        }
//    }    
    public static void main(String[] args) {
//      With Predicate
        Predicate<Integer> p = i -> i > 10;
        p.test(5);//false
        p.test(15);//true
    }
}
```
**Task:** Declare names in an array and print names which are starting with 'A' using lambda expression.

*Example like this:* `String names = {"Krishna", "Arjun", "Varun", "Amith", "Sunny"};`

### **Predicate Joining-**

- To Combine multiple predicates, we will use predicate joining
- In Predicate we have below methods
    - `test() `-> abstract method
    - p1.`negate();` -> flips the predicate
    - p1.`and(p2)` -> both predicates must be true
    - p1.`or(p2)` -> at least one must be true
> **Note:** negate(), and(), or() methods are default method in Predicate interface

*Example:*
```java
class Student{
    String name;
    int marks;
    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
}
public class Demo {
  public static void main(String[] args) {
    Predicate<Student> isFail = (f) -> f.marks <= 35;
    Predicate<Student> isPass = (p) -> p.marks >= 35;

    // Predicate joining
    Predicate<Student> isBoarderline = isFail.or(isPass).and(s -> s.marks == 35);
    Predicate<Student> isHighScorer = isPass.and(s -> s.marks > 90);
    Predicate<Student> isNotFail = isFail.negate();

    Student s1 = new Student("A", 30);
    Student s2 = new Student("B", 35);
    Student s3 = new Student("C", 95);

    System.out.println("A fails: " + isFail.test(s1));
    System.out.println("B borderline: " + isBorderline.test(s2));
    System.out.println("C high scorer: " + isHighScorer.test(s3));
    System.out.println("A NOT fail: " + isNotFail.test(s1));
  }
}
```
**1.1) BiPredicate interface**

Now suppose we have requirement where wer need to send two parameters (i.e, Person object and min age to vote) and then return the result. Here, we can use `BiPredicate<T, T>.`

-  The `BiPredicate<T, T>` has a functional method `test(Object, Object)` . It takes in two parameters and returns a `boolean` value.

*Example:*
```java
public class Demo {
  public static void main(String[] args) {
    BiPredicate<String, Integer> filter = (x,y) ->{
        return x.length() == y;
    };
    
    boolean result = filter.test("Vamshi", 6);
    System.out.println(result); //true

    boolean result = filter.test("Vamshi", 13);
    System.out.println(result); //false
  }
}
```

---

**2) Supplier:-**

- Supplier is a pre-defined functional interface introduced in java 1.8v.
- it contains only single abstract method that is `T get()` method.
- Supplier will just provide output without any input.

*use case:-*
- **Error Handling:** Providing error messages or exceptions when certain conditions are encountered.
- **Default Values:** Supplying a default value when a specific condition is not met.
- **Generating Data:** Providing random numbers (link, OTP-Generator and etc.), Unique Ids, or other generated data.
- **Lazy Initialization:** Deferring the creation of an object until it is actually needed.

*Example:-*
```java
public class Demo {
  public static void main(String[] args) {
    // Create a Supplier that provides a String
    Supplier<String> greetingSupplier = () -> "Hello from Supplier!";

    // Get the value from the Supplier
    String message = greetingSupplier.get();
    System.out.println(message); // Output: Hello from Supplier!

    // Another example: supplying a random number
    Supplier<Double> randomNumberSupplier = () -> Math.random();
    System.out.println("Random number: " + randomNumberSupplier.get());
  }
}
```

---

**3) Consumer:-**

- Consumer is a pre-defined functional interface
- It contains one abstract method: `void accept(T t)`.
- Consumer will accept input but it won't return anything
- Commonly used with `forEach`.

*Note:* in java 8 `forEach()` method got introduced `forEach(Consumer consumer)` method will take Consumer as parameter.

*Example:-*
```java
public class Demo{
  public static void main(String[] args) {
    Consumer<String> c = (name) -> System.out.println(name + ", Good Evening");
    c.accept("Ram");
    c.accept("Krishna");
    c.accept("Hari");
    
    List<Integer> numbers = Arrays.asList(10,20,30,40);
    numbers.forEach(i -> System.out.println(i));
  }
}
```

**3.1) BiConsumer<T,U>**

- This interface takes two parameter and return noting.

- T - the type of the first argument to the operation
- U - the type of the second argument to the operation.

This interface has the same methods as present in the `Consumer<T>` interface.

```java
public class Demo{
  public static void main(String[] args) {
    BiConsumer<String, String> greet = (s1,s2) -> System.out.println(s1, s2);
    greet.accept("Vamshi", "Ji");
  }
}
```


---

**4) Function<T, R>:-**

- Function is pre-defined functional interface.
- That takes an object of type T and return an Object of type R.
- It takes input and it returns output.
- It is having one abstract method that is `R apply(T t)`.

*Example:*
```java
interface Function<R, T>{
    R apply(T t);
}
```
*Code Example:*
```java
import java.util.function.Function;

public class Demo{
  public static void main(String[] args) {
      //Create a function which takes string return the length of string.
    Function<String, Integer> lengthFunction = str -> str.length();
    System.out.println("String length: " + lengthFunction.apply("Hello, Vamshi here"));
    
    //Program to remove space in String using Function
    Function<String, String> f1 = s -> s.replaceAll(" ", " ");
    System.out.println(f1.apply("Lean here lead anywhere"));
    
    //Program to count no.of space in given String
    Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", " ").length();
    System.out.println(f2.apply("fdfsdfs"));
  }
}
```

**4.1) BiFunction<T,U,R>**

The `BiFunction<T, U, R>` is similar to `Function<T, R>` interface;
the only difference is that the
`BiFunction<T,U,R>` interface take in two parameter and returns and output.

In the below example, we will create a BiFunction that takes two numbers as input and 
return their sum.

*Example*
```java
import java.util.function.BiFunction

public class Demo{
  public static void main(String[] args) {
    BiFunction<Integer, Integer> add = (a,b) -> a+b;
    System.out.println("Sum = " + add.apply(2, 4));
  }
}
```

---

## Retrieve student record based on student id and return the record.

**Predicate ------> Take's input -----> return boolean**

**Supplier  -------> will not take any input -----> return's output**

**Consumer -----> take's input -----> return's Nothing.**

**Function -------> will take input -----> will return output**

