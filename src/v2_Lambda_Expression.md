# Lambda Expressions
---

---

### 📘 Introduction
- **Introduced in Java 8 (1.8v)**
- Traditionally, Java is an **Object-Oriented Programming (OOP)** language, everything is represented using **classes and objects**.
- From **Java 8**, Java also supports **Functional Programming** features.

---

### 🧩 Object-Oriented vs Functional Programming

| Concept | Object-Oriented Programming (OOP) | Functional Programming (FP) |
|----------|----------------------------------|------------------------------|
| Focus | Classes & Objects | Functions |
| Method location | Defined inside a class | Can exist independently (like values) |
| Data handling | Through objects | Through function calls |
| Example use | Inheritance, polymorphism | Stream operations, lambda expressions |

---

### 🧠 What is Functional Programming?

Functional programming means representing behavior using **functions** rather than classes or objects.

In this style:
- A **function can be stored** in a variable.
- A **function can be passed** as a parameter to another method.
- A **function can be returned** from another function.

This makes code more **concise, readable, and reusable** — especially useful with **Streams** and **collections** in Java 8.

-> **Lambda Expressions** were introduced in Java 8 to enable **Functional Programming**.

---

### What is Lambda ?

A **Lambda Expression** is basically an **anonymous function**, meaning a function **without a name**.

**Lambda functions:**
- Have **no name**
- Have **no modifiers** (like `public`, `private`)
- Have **no return type** (it is inferred automatically)

In simple terms:
> A **Lambda Expression** is a short way to write a function that can be passed around as data.

---

## 💡 Lambda Expression Example

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
```java
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

```java
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

```java
Number is even
```
---

### Task 5 — Lambda with ForEach (Collections)

✅ **Goal:** Use lambda with Java Collections.

**Steps:**

1. Create a List<String> of names.
2. Use forEach() with lambda to print each name in uppercase.
3. 

💡 *Expected Output:*

```java
ALEX
BRIAN
CHARLIE
```
---

### Task 6 — Lambda with Comparator

✅ **Goal:** Use lambda to sort a list.

**Steps:**

1. Create a List<Integer> with random numbers.
2. Sort it in descending order using Collections.sort() with a lambda comparator.
3. Print the sorted list.

💡 *Hint:*

```java
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

```java
Addition: 15  
Subtraction: 5  
Multiplication: 50
```
---

## Bonus Task — Real-World Practice
**Use lambda expressions with:**
- `Runnable` interface (for threads)
- `Predicate`, `Consumer`, `Function` (Java built-in functional interfaces)
- `Stream` API (`filter()`, `map()`, `forEach()`)


