### ⚙️ Common Built-in Functional Interfaces

-> In java 8 several predefined Functional interfaces got introduces they are:

| Interface | Package | Method | Purpose |
|------------|----------|---------|----------|
| Predicate<T> | java.util.function | test(T t) | Returns boolean |
| Function<T,R> | java.util.function | apply(T t) | Returns result |
| Consumer<T> | java.util.function | accept(T t) | Performs action |
| Supplier<T> | java.util.function | get() | Supplies value |

-> The above interfaces are provided in java.util.function package

**1) Predicate:-**
- It is predefined Functional interface.
- It is used check condition and returns true or false value.
- Predicate interface having only one abstract method that is `boolean test(T t);`
- Use a Predicate in Java when you need to test a condition on an object and return
  a boolean result (e.g., filtering or validation logic).

`Example:-`
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

*Example like this:* `String names = {"Krishna", "Arjun", "Rushi", "Amith", "Sunny"};`

---