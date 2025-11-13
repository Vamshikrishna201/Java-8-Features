# Lambda Expressions

---

### Introduction
- **Introduced in Java 8 (1.8v)**
- Traditionally, Java is an **Object-Oriented Programming (OOP)** language, everything is represented using **classes and objects**.
- From **Java 8**, Java also supports **Functional Programming** features.

---

### Object-Oriented vs Functional Programming

| Concept | Object-Oriented Programming (OOP) | Functional Programming (FP) |
|----------|----------------------------------|------------------------------|
| Focus | Classes & Objects | Functions |
| Method location | Defined inside a class | Can exist independently (like values) |
| Data handling | Through objects | Through function calls |
| Example use | Inheritance, polymorphism | Stream operations, lambda expressions |

---

### What is Functional Programming?

Functional programming means representing behavior using **functions** rather than classes or objects.

In this style:
- A **function can be stored** in a variable.
- A **function can be passed** as a parameter to another method.
- A **function can be returned** from another function.

This makes code more **concise, readable, and reusable** — especially useful with **Streams** and **collections** in Java 8.

-> **Lambda Expressions** were introduced in Java 8 to enable **Functional Programming**.

---

### What is a Functional Interface?

Functional Interfaces are used to invoke **lambda expressions.**

The `interface` which **contains only one `abstract` method** is called as **Functional Interface**
    
`Runnable`-----> run() method

`Callable`-----> call() method

`Comparable`--> compareTo() method

-> To represent one Interface as functional interface we will use `@FunctionalInterface` annotation

```java
@FunctionalInterface
public interface MyInterface {
   void m1();
}

```

> `NOTE:` When we write *`@FunctionalInterface`* then our compiler will check interface contains only one abstract method or not.

---

### Example 1 — Simple Functional Interface

```java
@FunctionalInterface // optional but recommended annotation
interface Greeting {
    void sayHello();// only one abstract method
}

public class Main {
    public static void main(String[] args) {
        // Using lambda to implement the functional interface
        Greeting g = () -> System.out.println("Hello, World!");
        g.sayHello();
    }
}
```

## 🔑 Key Points
- Must have exactly one abstract method.
- Can have any number of default or static methods.
- Annotated with @FunctionalInterface (optional but helps the compiler ensure correctness).
- Used as the target type for lambda expressions.

---

### What is Lambda?

A **Lambda Expression** is basically an **anonymous function**, meaning a function **without a name**.

**Lambda functions:**
- Have **no name**
- Have **no modifiers** (like `public`, `private`)
- Have **no return type** (it is inferred automatically)

In simple terms:
> A **Lambda Expression** is a short way to write a function that can be passed around as data.

**Example:-** *Syntax Template*
```
(parameter_list) -> {  
    // body  
}
```
---

### 💡 Lambda Expression Example

### Before Java 8 (Normal Function)
```java
// Functional interface — only one abstract method
interface Greeting {
    void sayHello();
}

class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeting g = new Hello();  // create object of class
        g.sayHello();              // call the method
    }
}
```
### ⚡ After Java 8 (Using Lambda Expression)

```java
interface Greeting {
   void sayHello();
}

public class Main {
    public static void main(String[] args) {
        // Lambda replaces the need for a separate class
        Greeting g = () -> System.out.println("Hello, World!");
        g.sayHello();  // directly calls lambda implementation
    }
}
```
> `NOTE:-` When we have single line in body then curly braces `{}` are optional.

---


---
## 🧠 Lambda Expression Practice Tasks (Beginner Level)

---

### 🏁 Task 1 — Basic Syntax Practice
✅ **Goal:** Create and use a simple lambda.

**Steps:**
1. Create a functional interface called `Sayable` with a method `say()`.
2. Implement it using:
   - A **normal class**, and  
   - A **lambda expression**.
3. Print `"Hello Lambda!"` from both.

💡 *Hint:*  
```
Sayable s = () -> System.out.println("Hello Lambda!");
s.say();
```

---

### Task 2 — Lambda with Parameters

✅ **Goal:** Create a lambda that takes parameters.

**Steps:**

1. Create an interface Addable with a method add(int a, int b).
2. Implement it using a lambda to return the sum.
3. Call it and print the result.

💡 *Expected Output:*

```
Sum is: 30
```

---

### Task 3 — Lambda with Return Value

✅ **Goal:** Return a value from a lambda expression.

**Steps:**

1. Create an interface Square with a method calculate(int n).
2. Use lambda to return the square of n.
3. Test it with a few numbers.

💡 *example:*

    Input: 5 → Output: 25

---

### Task 4 — Lambda with Conditional Logic

✅ **Goal:** Use a lambda with an if-else condition.

**Steps:**

1. Create an interface CheckEven with method isEven(int n).
2. Use lambda to check whether n is even or odd.
3. Print the result.

💡 *Expected Output:*

```
Number is even
```
---

### Task 5 — Lambda with ForEach (Collections)

✅ **Goal:** Use lambda with Java Collections.

**Steps:**

1. Create a List<String> of names.
2. Use forEach() with lambda to print each name in uppercase.

💡 *Expected Output:*

```
Vamshi
Amol
Amith
```
---

### Task 6 — Lambda with Comparator

✅ **Goal:** Use lambda to sort a list.

**Steps:**

1. Create a List<Integer> with random numbers.
2. Sort it in descending order using Collections.sort() with a lambda comparator.
3. Print the sorted list.

💡 *Hint:*

```
Collections.sort(list, (a, b) -> b - a);
```
---

### Task 7 — Lambda with Custom Functional Interface

✅ **Goal:** Combine everything you learned.

**Steps:**

1. Create your own interface Operation with a method perform(int a, int b).
2. Implement multiple lambdas for:
    - Addition
    - Subtraction
    - Multiplication
3. Call each and print results.

💡 *Expected Output:*

```
Addition: 15  
Subtraction: 5  
Multiplication: 50
```
---

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

## ⚠️ ❌ Common Mistakes 
- Using lambda without a functional interface.
- defububg nire than one abstract method in a functional interface.
- Expecting `this` to refer to the lambda itself (it refers to the outer class).
- Trying to overload lambda signatures incorrectly.
- Forgetting type interface rules (sometimes need explicit parameter types).

---
## Bonus Task — Real-World Practice
**Use lambda expressions with:**
- `Runnable` interface (for threads)
- `Predicate`, `Consumer`, `Function` (Java built-in functional interfaces)
- `Stream` API (`filter()`, `map()`, `forEach()`)

---

