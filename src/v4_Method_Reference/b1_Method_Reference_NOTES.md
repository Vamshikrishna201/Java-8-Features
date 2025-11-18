# ⭐ Method Reference (Java 8)

---

Method Reference is a feature introduced in Java 8 that allows you to **refer to an existing method instead** of writing a lambda expression.

It is basically a shorter, cleaner alternative to a lambda,** but only when the lambda is directly calling an existing method.**

### Why Method Reference Exists?

Because sometimes your lambda is doing nothing except calling another method.

Example:

```
list.forEach(s -> System.out.println(s));
```
This lambda literally duplicates `System.out::println`.

Method reference removes this duplication and makes the intention clearer.

---

### Types of Method References (4 Types)
There are only four types
Understand these four → you understand the entire concept

**1) Reference to a Static Method**

syntax:
```
ClassName::staticMethodName
```
Use this ONLY when the lambda is calling a static method.

**Example without method reference**

```java
Function<Integer, Integer> f = n -> Math.abs(n);
```

**With method reference**

```java
Function<Integer, Integer> f = Math::abs;
``` 
*Code example:*
```java
@FunctionalInterface
interface MyInterface{
    public void m1();
}
public class MethodRef{
    public static void m2(){
        System.out.println("This is m2() method");
    }

    public static void main(String[] args) {
        MyInterface mi = mi = MethodRef::m2;
        mi.m1(); 
    }
}
```
---

**2) Reference to an Instance Method of a Particular Object**

syntax:
```
object::instanceMethodName
```

*Code example:*
```java
@FunctionalInterface
interface MyInterface{
    public void m1();
}
public class InstanceMethodRef{
    public void m1(){
        for(int i = 1; i<= 5; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        InstanceMethodRef imr = new InstanceMethodRef();
        
        Runnable r = imr::m1;
        // run() is replased by m1
        Thread t = new Thread(r);
        t.start();
    }
}
```

**Example - 2**

```
String msg = "Hello";
Supplier<Integer> s = msg::length;
System.out.println(s.get()); // 5
```

Here `msg.length()` was going to be used inside a lambda, so the method reference is allowed.

---

**3) Reference to an Instance Method of an Arbitrary Object of a Particular Type**

syntax:

```
ClassName::instanceMethod
```
This looks similar to static reference, but it is not static.

It applies when the first argument of the lambda becomes the calling object.

**Example**

Without method reference:
```
Predicate<String> p = str -> str.isEmpty();
```
With method reference:
```
Predicate<String> p = String::isEmpty;
```
Java knows that the String object passed during `test()` is the object on which `isEmpty()` will be called.

*code Example:*
```java
public class Demo {
    public static void main(String[] args) {
        // Without method reference
        Predicate<String> p1 = str -> str.isEmpty();

        // With method reference
        Predicate<String> p2 = String::isEmpty;
        System.out.println(p2.test("")); //true

        System.out.println("Hi"); //false
        // Here the String passed ti test() becomes the object for isEmpty().
    }
}
```
---

**4) Reference to a Constructor**

Syntax:
```
ClassName::new
```
Used when the lambda is creating an object.

Example when the lambda is creating an object.

```
Supplier<Student> s = () -> new Student();
```
With method reference:

```
Supplier<Student> s = Student::new;
```

*code Example:*
```java
public class Test{
    public static void main(String[] args) {
        // Doctor d = new Doctor();
        Supplier<Doctor> s = Doctor::new;
        Doctor doctor = s.get();
        System.out.println(doctor.hashCode()); // output: 41157191
    }
}
class Doctor(){
    public Doctor(){
        System.out.println("Doctor constructor...");
    }
} 
```

---

## When to Use Method Reference?

Use it ONLY when:
- Your lambda calls an existing method
- Your lambda has no extra logic
- Your lambda parameters directly match the method’s parameters

If your lambda has **any extra logic**, you CANNOT use method reference.

**Example (invalid for method reference):**
```
list.forEach(s -> {
    System.out.println("Name: " + s); // additional logic
});
```

Method reference is not allowed because logic is added.

---

## forEach Method Reference

**Use of forEach Method:**
The forEach method provides a clean and readable way to process 
each element in a collection without explicitly writing a for loop.

*Syntax:*
```bash
collection.forEach(element -> action_to_perform_on_element);
```

- forEach (Consumer c) method introduced in java 1.8v
- forEach() method added in iterable interface.
- forEach() method is a default method (it is having body).
- This method is used to access each element of the Collection (Traverse collection from start to end.).

*Example where method reference is allowed:*
```
list.forEach(x -> System.out.println(x));
```

*Example where method reference is NOT allowed:*
```
list.forEach(x -> System.out.println(x + " ok"));
```

code example:

```java
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(3);
        al.add(4);
        al.add(1);
        al.add(2);
        
        // The parameter of forEach(Consumer<? super E> action)
        // Consumer --> take's input --> return's nothing
        al.forEach( (i) -> System.out.println(i + ", "));
    }
}
```

*Static method printing*
```java
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Arrays.asList("A", "B", "C").forEach(System.out::println);
    }
}
```

*With custom class*
```java
import java.util.Arrays;

class Printer {
    public void printValue(int n) {
        System.out.println("Value: " + n);
    }
}
public class Demo {
    public static void main(String[] args) {
        
        Printer p = new Printer();

        Arrays.asList(1, 2, 3).forEach(p::printValue);
    }
}
```
