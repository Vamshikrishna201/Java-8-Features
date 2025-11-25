# Stream API (Java 8) – Notes

---

## Introduction

- **Stream API** was introduced in **Java 1.8 (Java 8)**.
- A **Stream is NOT a data structure**.
- Stream API is used to **process data** efficiently.
- It can process data from both:
  - **Collections**
  - **Arrays**

> **Note:** Collections are used to **store data**.
> Streams are used to **process data**.

---

## What is a Stream?

- A Stream is a **sequence of elements** coming from a **source**.
- Source can be:
  - A **Collection**
  - An **Array**
- Stream does **not** modify the original data structure.  
  It only **processes** the data and returns the result.

---

## Key Points About Streams

1. A Stream is **not** a Data Structure (DS).
2. A Stream is a **pipeline of operations** applied on data.
3. Stream **does not change** the original list/array;  
   it creates a **processed view** of the data.
4. Stream processing happens in a **lazy** manner  
   (operations are executed only when a terminal method is called).

---

## Stream Creation

In Java, Streams can be created in two common ways:

### 1. Using `Stream.of(...)`

`Stream.of()` → Use this to **create a stream from specific values directly**, without needing a collection first.

```java
public class Demo{
    public static void main(String[] args) {
        //Approch - 1
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);        
    }
}
```

---

### 2. Using `stream()` method from a Collection

`stream()` → Use this on an **existing collection like** a `List` or `Set` to turn its elements into a stream.


```java
public class Demo{
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Krishna");
        names.add("Hari");
        
        Stream<String> stream2 = names.stream();
    }
}
```

> **Think:** `stream()` = **collection → stream,** `Stream.of()` = **values → stream**.


## Full Example:

```java[ex7_Stream.java](ex7_Stream.java)
public class Demo {
    public static void main(String[] args) {
        
        // Approach 1 → Direct stream creation
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Krishna");
        names.add("Hari");

        // Approach 2 → Stream from Collection
        Stream<String> stream2 = names.stream();
    }
}
```

---

## Stream Operations

- Stream API provides many methods to process data.
- These methods are divided into two categories:

1) Intermediate Operation Methods
    - These transform the data and return a **new Stream**.
    - They **do NOT** produce the final result
    - They are executed **only when a terminal operation is called.**

Example:-
  - `filter()`
  - `map()`
  - `sorted()`
  - `distinct()`

---

2) Terminal Operational Methods
    - These **end the stream pipeline**
    - They product the **final result** (value, collection, etc.).
    - Once a terminal operation is executed, the stream ** cannot be used again.**

Example:-
  - `count()`
  - `collect()`
  - `forEach()`
  - `reduce()`

---

## Filtering with Streams

- Filtering means getting required data from original data
    - **Ex:-** get only even numbers from give numbers
    - **Ex:-** get emps whose salary is >= 1,00,000
    - **Ex:-** get Mobile whose price is <= 20,000
  
---

- To apply filter on the data Stream api provided `filter()` method.
  - **Ex:-** Stream filter(Predicate p)

--- 

### Example: Filter even numbers
```java
public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30);

    List<Integer> evens = nums.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

    System.out.println(evens); // [10, 20, 30]
}
```

### Example: Filter names starting with 'A'
```java
public static void main(String[] args) {
    List<String> names = Arrays.asList("Amit", "Rohan", "Ajay");

    List<String> result = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());

    System.out.println(result); // [Amit, Ajay]
}
```

---

## Mapping Operations

- Mapping operations belong to **Intermediate Operations** in the Stream API.
- `map()` is used to **transform each element** of the stream.
- It returns a **new Stream** containing transformed elements.

**Method Signature:**
```java
Stream<R> map(Function<? super T, ? extends R> mapper);
```
---

### Example 1: Convert each name to uppercase

```java
public static void main(String[] args) {
    List<String> names = Arrays.asList("ram", "krishna", "hari");

    List<String> upper = names.stream()
            .map(str -> str.toUpperCase())
            .collect(Collectors.toList());

    System.out.println(upper); // [RAM, KRISHNA, HARI]
}
```

---

### Example 2: Convert numbers to their squares

```java
public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(2, 4, 6);

    List<Integer> squares = nums.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

    System.out.println(squares); // [4, 16, 36]
}
```

---

### Example 3: Extract length of each string

```java
public static void main(String[] args) {
    List<String> cities = Arrays.asList("Delhi", "Mumbai", "Pune");

    List<Integer> lengths = cities.stream()
            .map(city -> city.length())
            .collect(Collectors.toList());

    System.out.println(lengths); // [5, 6, 4]
}
```

---

## What is **flatMap(Function f)** Method?

- `flatMap()` is used when your data is inside another data structure (nested), and you want to flatten it + process it in one shot.
    - `map()` → **transforms each element**
    - `flatMap()` → **transforms AND flattens nested structure**

If your stream contains something like:

    - List of Lists
    - List of Arrays
    - List of Optional
    - List of Objects that return List
    - Anything nested

Then `map()` will give you a Stream of Stream (useless)
But `flatMap()` will flatten it into a single plain Stream (useful)

> **Note:** `flatMap()`is used to convert a nested structure (Stream of List/Stream) into a single flattened Stream by applying a function that returns a Stream.
 
### 🧨 The simplest way to remember

- **map → 1 input → 1 output**
- **flatMap → 1 input → MANY outputs → but flatten back into ONE stream**

*Example 1 (Beginner Friendly) — List<List<Integer>>*

**❌ Without flatMap (wrong way)**

```java
public static void main(String[] args) {
    List<List<Integer>> nums = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5, 6)
    );

    nums.stream()
            .map(list -> list.stream())   // Stream<Stream<Integer>>
            .forEach(System.out::println);
}
```
Output becomes nested streams — USELESS.

---

**✅ With flatMap (correct)**
```java
public static void main(String[] args) {
    List<List<Integer>> nums = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5, 6)
    );
    
    nums.stream()
        .flatMap(list -> list.stream())   // Stream<Integer>
        .forEach(System.out::println);
}
```

---

### Example 2 — List<String> → split words → flatten

```java
public static void main(String[] args) {
    List<String> names = List.of("Ram Hari", "Krishna Shiv", "Vishnu");

    names.stream()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .forEach(System.out::println);
}
```
If you used map(), you’d get Stream<String[]> → garbage.

---

**Example 3 — Object → returns List**

```java
class Student {
    String name;
    List<String> subjects;

    Student(String n, List<String> s) {
        this.name = n;
        this.subjects = s;
    }

    List<String> getSubjects() {
        return subjects;
    }
}
//Using flatMap:
public static void main(String[] args) {
    List<Student> students = List.of(
            new Student("Ram", List.of("Math", "Java")),
            new Student("Shyam", List.of("Python", "DB"))
    );

    students.stream()
            .flatMap(s -> s.getSubjects().stream())
            .forEach(System.out::println);

}
```

---

## Slicing Operations in Stream API

Slicing operations allow you to `cut`, `limit`, or `filter out duplicates` from a stream without touching the original data.

All slicing methods are `Intermediate Operations` → they return a new Stream.

1. `distinct()` => Removes duplicate elements from the stream, Works by using `.equals()` and `hashCode()` internally.

**Example:**

```java
public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 2, 3, 3, 3, 4);

    list.stream()
            .distinct()
            .forEach(System.out::println); // 1 2 3 4

}
```
---

2. `limit (long maxSize)` => Takes the first **maxSize** elements from the stream. Useful when you want **top N items**.

**Example:-**

```java
public static void main(String[] args) {
    List<Integer> list = List.of(10, 20, 30, 40, 50);

    list.stream()
            .limit(3)
            .forEach(System.out::println); // 10 20 30
}
```

---

3. `skip (long n)` => Skips the **first n elements** of the stream.

**Example:-**

```java
public static void main(String[] args) {
    List<Integer> list = List.of(10, 20, 30, 40, 50);

    list.stream()
            .skip(2)
            .forEach(System.out::println); //30 40 50
}
```

**NOTE:** All the above 3 methods are comes under intermediate Operational Methods. THey will perform operation and returns new Stream.

---

### Combined Example (Best for Understanding)

```java
public static void main(String[] args) {
    List<Integer> list = List.of(1,2,2,3,3,4,5,6,7,8);

    list.stream()
            .distinct()   // remove dupes → 1,2,3,4,5,6,7,8
            .skip(2)      // skip first 2 → 3,4,5,6,7,8
            .limit(3)     // take first 3 → 3,4,5
            .forEach(System.out::println);
}
```

---

## Matching Operations in Stream API

Matching operations are **Terminal Operations.**
They check whether stream elements satisfy a **Boolean condition.**

They **return boolean** (`true` / `false`) and close the stream.

1) `anyMatch(Predicate condition)`
   Checks if at least one element matches the condition.

**Example:**
```java
public static void main(String[] args) {
    List<Integer> nums = List.of(10, 20, 30, 40);

    boolean result = nums.stream()
            .anyMatch(n -> n > 25);

    System.out.println(result); // true
}
```

2) `allMatch(Predicate condition)`
   Checks if **every element** satisfies the condition.

**Example**
```java
public static void main(String[] args) {
    List<Integer> nums = List.of(10, 20, 30);

    boolean result = nums.stream()
            .allMatch(n -> n > 5);

    System.out.println(result); // true
}
```

3) `3) noneMatch(Predicate condition)`
   Checks if **no element** matches the condition.

```java
public static void main(String[] args) {
    List<Integer> nums = List.of(10, 20, 30);

    boolean result = nums.stream()
            .noneMatch(n -> n < 0);

    System.out.println(result); // true

}
```
---
### Quick Summary Table

| **Method**     | **Meaning**             | **When true?**           |
|----------------|-------------------------|--------------------------|
| `anyMatch()`   | At least one matches    | If one OR more matches   |
| `allMatch()`   | All must match          | If every element matches |
| `noneMatch()`  | No element should match | If zero elements match   |

> **Note:** The above 3 Methods are belongs to Terminal Operaitons

---

## `collect()` — Terminal Operation

`collect()` is a **Terminal Operation** in the Stream API.

It is used to convert a stream into:
    
    - List
    - Set
    - Map
    - String
    - Custom Collection
    - And more (grouping partitioning)

---

### ✅ 1) Basic Syntax

```
<R, A> R collect(Collector<? super T, A, R> collector)
```

Relax, you’re not supposed to remember that.
Just remember this:
- `collect()` converts stream data into a final collection or result.
- It uses Collectors helper class.

---

### Most Common Usage (You MUST know these)

1. `Collectors.toList()`**Convert Stream → List**

```java
//Task:-1 Convert List of numbers list of squares
public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7);

    List<Integer> number = list.stream()
            .map(i -> i * i)
            .collect(Collectors.toList());
    System.out.println("Square Numbers:- " + number);
}
```

---

2. `Collectors.toSet()`**2. Convert Stream → Set**

```java
//TASK 2 — Get All Odd Numbers Into a Set
public static void main(String[] args) {
    List<Integer> n = Arrays.asList(4,5,6,7,8,2,1,7,8);

    Set<Integer> set = n.stream().filter(i -> i% 2 != 0)
            .collect(Collectors.toSet());

    System.out.println(set); //[1, 5, 7]
}
```
---

3. `toMap()`**Convert Stream → Map**

You MUST give **keyMapper** and **valueMapper**.

```java
class Emp {
    int id;
    String name;

    //add constructor + getter
}
//TASK 3 — Convert List<Employee> in to Map<id, name>
public static void main(String[] args) {
    List<Emp> emp = Arrays.asList(
            new Emp(1, "A"),
            new Emp(2, "B"),
            new Emp(3, "C")
    );
    Map<Integer, String> mapEmp = emp.stream()
            .collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
    System.out.println(mapEmp);
}
```
If duplicate keys occur → it throws an exception unless you give a merge function.

---

4. `Collectors.joining()`**Join Elements into a String (VERY commonly asked)**

```java
public static void main(String[] args) {
    List<String> nam = Arrays.asList("Ram", "Krishna", "Hari");

    String result = nam.stream()
            .map(i -> i.toUpperCase())
            .collect(Collectors.joining(", "));
    //Collectors.joining does NOT return a List, it returns a String
    System.out.println(result);
}
```
Output:
`Ram, Krishna, Hari`

---

5. `Collectors.counting()`**Count elements (though count() already exists)**

```java
public static void main(String[] args) {
    List<String> students = Arrays.asList(
            "Vamshi",
            "Prem", "Vipul",
            "Pratik", "Soham");

    long count = students.stream().collect(Collectors.counting());
    System.out.println(count);//5
}
```

6. `Collectors.maxBy()`

---

## ⭐ Advanced collect() Operations

These are **interview favorites**. Learn them.

---

7. **Grouping Data →** `groupingBy()`

**Goal:** Group items based on a key (length, first letter, price range, anything).
-> Group By is used to categorize the data/Grouping the data.
**Example →** Group names by their length
```java
public static void main(String[] args) {

    List<String> names = Arrays.asList("Ram", "Krishna", "Hari");

    Map<Integer, List<String>> grouped =
            names.stream()
                    .collect(Collectors.groupingBy(name -> name.length()));
    System.out.println(grouped);
}
```

Output example:
```
3 -> [Ram]
7 -> [Krishna]
4 -> [Hari]
```

---

8. **Summing →** `summingInt()`

Example → Find total of all numbers

```java
 public static void main(String[] args) {

    List<Integer> nums = Arrays.asList(10, 20, 30, 40);

    int total = nums.stream()
            .collect(Collectors.summingInt(n -> n));

    System.out.println("Total = " + total);
}
```

---

9. **Averaging →** `averagingInt()`

Example → Find average of numbers
```java
public static void main(String[] args) {

    List<Integer> nums = Arrays.asList(10, 20, 30, 40);

    double avg = nums.stream()
    .collect(Collectors.averagingInt(n -> n));
    System.out.println("Average = " + avg);
    }
```

---

### More Examples on `groupingBy()`

Why this matters?

Because real data is rarely flat.

You group based on multiple fields, count inside groups, sum inside groups,
or get maps inside maps.

-> **Example:** Group Employees by Department
```java
   Map<String, List<Employee>> deptWise =
          employees.stream()
              .collect(Collectors.groupingBy(emp -> emp.dept));
```

-> **Example:** group employees by department and count them.
```java
Map<String, Long> countByDept =
          employees.stream()
                 .collect(Collectors.groupingBy(emp -> emp.dept,
                     Collectors.counting()));
//System.out.println(countByDept);
```

-> **Example:** group department average Salary by Department
```java
Map<String, Double> avgSalary =
        employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.dept,
                        Collectors.averagingInt(emp -> emp.salary)));
//System.out.println(avgSalary);
```

-> **Example:** total salary per department.
```java
Map<String, Integer> salaryMap = employees.stream()
    .collect(Collectors.groupingBy(emp -> emp.getDept(),
             Collectors.summingInt(emp -> emp.getSalary())));
```

-> **Example:** find the employee with max salary in each department.
```java
Map<String, Optional<Employee>> topSalary = employees.stream()
    .collect(Collectors.groupingBy(emp -> emp.getDept(),
             Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
```

-> **Example:** Find Highest Salary Employee in Each Department

```java
   Map<String, Optional<Employee>> highestSal =
       employees.stream()
           .collect(Collectors.groupingBy(emp -> emp.dept,
               Collectors.maxBy(Comparator.comparing(e -> e.salary))));
```

-> **Example:** Convert to Set Instead of List

```java
Map<String, Set<String>> deptNameSet = employees.stream()
    .collect(Collectors.groupingBy(emp -> emp.getDept(),
             Collectors.mapping(emp -> emp.getName(),
                                Collecters.toSet())));
```

---

## **Partitioning Data →** `partitioningBy()`

- It takes a Predicate (a function that returns true or false).

- It always creates a Map with a Boolean key:
  - true **Key**: Holds a List of all elements that match the condition.
  - false **Key**: Holds a List of all elements that do not match the condition.

**Goal:** Split data into **true group** and **false group**
(only works on boolean conditions).

**Example →** Partition numbers into even & odd

```java
class Employee {
    int id;
    String name;
    String dept;
    int salary;
    int age;
    Employee(int id, String name, String dept, int salary, int age) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
    }
    public String toString() {
        return name + " (" + dept + ", " + salary + ")";
    }
}
public class Main(){
public static void main(String[] args) {
    List<Integer> num = Arrays.asList(1,2,3,4,5,6,7);

    //TASK-1 check even numbers from List of arrays
    Map<Boolean, List<Integer>> even = num.stream()
            .collect(Collectors.partitioningBy( i -> i % 2==0));
    System.out.println(even);//{false=[1, 3, 5, 7], true=[2, 4, 6]}

    //TASK2 count even & odd numbers.
    Map<Boolean, Long> count = num.stream()
            .collect(Collectors.partitioningBy( n -> n % 2==0,
                    Collectors.counting()));
    System.out.println(count);//{false=4, true=3}
    //Use Map<Boolean, Long> because counting() returns Long.

    //TASK-3 sum even vs odd numbers.
    Map<Boolean, Integer> sumMap =
            num.stream()
                    .collect(Collectors.partitioningBy(n -> n % 2==0,
                            Collectors.summingInt(n -> n)));
    System.out.println(sumMap);//{false=16, true=12}

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    List<Emp> emp = Arrays.asList(
            new Emp(1, "Vamshi",500000.00 , "INDIA", "IT"),
            new Emp(2, "Krishna",22000.00 , "INDIA", "Contractor"),
            new Emp(3, "Jay",240000.00 , "INDIA", "Marketing"),
            new Emp(4, "John",18000.00 , "US", "Finance"),
            new Emp(5, "Parth",26000.00 , "INDIA","Sales")
    );
    //TASK-4 separate employees by department or gender → return only names.
    Map<Boolean, Set<String>> seprateEmp = emp.stream()
            .collect(Collectors.partitioningBy(e -> e.getDepartment().equals("IT"),
                    Collectors.mapping( n -> n.getName(),
                            Collectors.toSet())));;
    System.out.println(seprateEmp);//{false=[Parth, Krishna, Jay, John], true=[Vamshi]}

    //TASK-5 : highest salary among of Employee
    Map<Boolean, Optional<Emp>> highSal = emp.stream()
            .collect(Collectors.partitioningBy(n->n.getDepartment().equals("IT"),
                    Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
    System.out.println(highSal);

    //Task-6 Partition Employees → Salary >= 60k
    Map<Boolean, List<Emp>> result =
            emp.stream()
                    .collect(Collectors.partitioningBy(e -> e.getSalary() >= 35000));
    System.out.println(result);
    }
}
```

---

## Partitioning vs Grouping

Add this comparison table in your notes (interview gold):

| **Feature**  | **`groupingBy()`**              | **`partitioningBy()`**    |
|--------------|---------------------------------|---------------------------|
| Output Keys  | Many (based on values)          | Only true and false       |
| Use case     | Categorize into multiple groups | Split into 2 groups       |
| Condition    | Any function                    | Only Boolean conditio     |
| Output Type  | `Map<K, List<V>>`               | `Map<Boolean, List<V>>`   |

---

### The Correct, Interview-Ready Explanation

**Difference between `groupingBy()` and `partitioningBy()`**

### `groupingBy()`
- Can create **multiple groups** based on any key (length, age, department…).
- Output: `Map<K, List<T>>`
- Group count depends on **data**.

### `partitioningBy()`
- Always creates exactly 2 groups → `true` and `false`.
- Output: `Map<Boolean, List<T>>`
- ONLY for boolean-based split.

---

## Quick Summary Table

| **Purpose**     | **Method**                           |
|-----------------|-----------------------------------|
| To List         | `Collectors.toList()               `|
| To Set          | `Collectors.toSet()  `              |
| To Map          |` Collectors.toMap() `               |
| Join Strings    | `Collectors.joining() `             |
| Count           | `Collectors.counting() `            |
| Grouping        | `Collectors.groupingBy()`           |
| Partitioning    | `Collectors.partitioningBy()    `   |
| Sum             |` Collectors.summingInt()  `         |
| Avg             | `Collectors.averagingInt()   `      |

---

## `reduce()` — The Real Meaning

**`reduce()` = Take a Stream → combine all elements → produce ONE result.**

That ONE result can be:
    
    - a number (sum, max, min)
    - a string (concatenation)
    - an object (custom merging)

it's like:
**Keep reducting data until only one calue remains.**

---

### 3 Versions of reduce()

**1️⃣ `reduce(identity, accumulator)`**

Most beginner-friendly & most used.

**Example1: Sum all numbers**
```java
public static void main(String[] args) {
    //example-1 Sum all numbers
    int sum = Arrays.asList(10, 20, 30, 40).stream()
            .reduce(0, (a, b) -> a + b);
    System.out.println(sum); // 100
    
    //example-2 - Multiply all numbers
    int product = Arrays.asList(1, 2, 3, 4).stream()
            .reduce(1, (a, b) -> a * b);
    System.out.println(product); // 24
    
    //example-3 Sum length of all strings
    int totalLength = Arrays.asList("Ram", "Krishna", "Hari").stream()
            .reduce(0, (sum, str) -> sum + str.length(), Integer::sum);
    System.out.println(totalLength); // 14
    
    //example-4 Concatenate all names into one string
    String joined = Arrays.asList("Ram", "Krishna", "Hari").stream()
            .reduce("", (a, b) -> a + b);
    System.out.println(joined); // RamShamHari
}
```
**identity = 0**
- Starting value
- Also the result if the list is empty

**accumulator = (a, b) -> a + b**
- `a` is the running result
- `b` is the next element

---

**2️⃣ `reduce(accumulator)` → Optional<T>**

Used when there is **NO identity.**
If stream is empty → gives Optional.empty.

**Example 2: Find MAX**

```java
public static void main(String[] args) {
    Optional<Integer> max = Arrays.asList(10, 3, 50, 7).stream()
            .reduce((a, b) -> a > b ? a : b);

    System.out.println(max.get()); // 50
}
```

---

**3️⃣ reduce(identity, accumulator, combiner)**

Used only in **parallel streams.**
Skip for now — not needed for interviews until you're advanced.

---

## 🧨 Super Important: `reduce()` vs `collect()`

| **Task**                    |    **Use**     |
|-----------------------------|:--------------:| 
| Summing small things        |   `reduce()`   |
| Combining into list/map/set |  `collect()`   | 
| Grouping/Partitioning       |  `collect()`   |
| Custom total value          |  `reduce() `   |

_If the interviewer asks:_

**Why do we need reduce if collect exists?**

You answer:

-> collect is for containers (List/Map/Set).

-> reduce is for single result (sum/max/min/custom total).

---

## Parallel Streams 

- `parallelStream()` (or `.parallel()`) runs stream operations using the **ForkJoinPool** and multiple threads.

- Use when work is **CPU-bound**, data is large, and operations are **stateless and independent**.

- Don’t use when operations are I/O-bound, data is small, order matters, or you mutate shared state.

---

### How to create
```
// From a collection
List<Integer> list = ...;
Stream<Integer> p = list.parallelStream();

// From a normal stream
Stream<Integer> s = list.stream();
Stream<Integer> p2 = s.parallel();
```

---

### **Simple example: parallel sum vs sequential sum**

```java
import java.util.*;
public class ParallelSum {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10_000_000; i++) nums.add(i);

        // Sequential sum
        long start1 = System.currentTimeMillis();
        long sum1 = nums.stream().reduce(0L, (a, b) -> a + b);
        long t1 = System.currentTimeMillis() - start1;
        System.out.println("Sequential time: " + t1 + " ms, sum=" + sum1);

        // Parallel sum
        long start2 = System.currentTimeMillis();
        long sum2 = nums.parallelStream().reduce(0L, (a, b) -> a + b);
        long t2 = System.currentTimeMillis() - start2;
        System.out.println("Parallel time: " + t2 + " ms, sum=" + sum2);
    }
}
```
> Expect parallel to be faster on multi-core CPUs for large N — but not guaranteed. Measure for your case.

--- 

### **Thread-safety & side-effects — the number-one trap**

**Never** mutate shared, external state inside a parallel stream. Example of BAD code:

```java
List<Integer> result = new ArrayList<>();
nums.parallelStream().forEach(n -> {
    if (n % 2 == 0) result.add(n); // BAD: shared mutable list -> race conditions
});
```

This can produce corrupted lists or throw `ConcurrentModificationException`. Don’t do this.

---

### **Correct ways to collect in parallel**

1) Use thread-safe collectors / concurrent collectors

```java
Map<Boolean, List<Integer>> parts = nums.parallelStream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```
`partitioningBy` is safe — it handles concurrency internally when used with parallel streams.

Better for maps/sets:

```java
ConcurrentMap<Integer, List<String>> grouped = employees.parallelStream()
    .collect(Collectors.groupingByConcurrent(
        e -> e.getDept()
    ));
```

2) Use `collect()` with proper **supplier/accumulator/combiner**

**Example:** build a list safely (but usually prefer collectors):

```java
List<Integer> evens = nums.parallelStream()
    .filter(n -> n % 2 == 0)
    .collect(
        () -> new ArrayList<Integer>(), // supplier
        (list, item) -> list.add(item), // accumulator (runs in thread)
        (l1, l2) -> l1.addAll(l2)       // combiner (merge partial results)
    );
```

---

### **forEach vs forEachOrdered**

- `forEach` in parallel may process elements in arbitrary order.
- `forEachOrdered` preserves encounter order — but can hurt parallel performance.

Use `forEach` when order doesn’t matter. Use `forEachOrdered` only when order matters.

---

### **When NOT to use parallel streams**

- Small collections (overhead kills benefit)
- I/O-bound operations (disk, network, DB calls)
- When code requires strict ordering or deterministic side-effects
- When using non-thread-safe data structures without proper collectors

---

### Practical examples (no method references)

Parallel grouping (concurrent)

```java
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelGrouping {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("A","B","C","D","E","F","G","H");

        ConcurrentMap<Integer, List<String>> byLen = names.parallelStream()
            .collect(Collectors.groupingByConcurrent(s -> s.length()));

        System.out.println(byLen);
    }
}
```

**Parallel max using reduce safely**

```java
Optional<Integer> max = nums.parallelStream()
    .reduce((a, b) -> a > b ? a : b);
```

---

**Performance tips — don’t guess, measure**

1. Always measure with real dataset and JVM arguments.
2. Use Runtime`.getRuntime()``.availableProcessors()` to get cores.
3. Avoid parallel streams in libraries meant to be used inside other parallel contexts (nested parallelism issues).
4. Consider custom `ForkJoinPool` if you need a different thread pool (advanced).

---

### Common interview questions & crisp answers

- **Q:** When should you use parallelStream?
  
    **A:** For large, CPU-bound, stateless operations where order doesn’t matter and 
    the cost of splitting/merging is justified.

- **Q:** Why is mutable shared state bad?
  
- **A:** Parallel threads may concurrently modify the same object 
  leading to race conditions and corrupted results. Use thread-safe collectors or immutable reduction.

- **Q:** How to safely collect in parallel?

  **A:** Use concurrent collectors (`groupingByConcurrent`, `toConcurrentMap`)
 or `collect()` with proper supplier/accumulator/combiner.

---

### Parallel Streams — Quick Rules
- Create: `list.parallelStream()` or `.parallel()`
 
- Use when: Large data, CPU-bound, stateless operations
 
- Avoid when: I/O-bound, small collections, order matters, shared mutable state
 
- Safe collecting: `Collectors.groupingByConcurrent()`, `Collectors.toConcurrentMap()`, or `collect(supplier, accumulator, combiner)`

- Beware: `forEach` is unordered; `forEachOrdered` preserves order but may reduce parallelism


---

## Java Spliterator

- Spliterator = “Split + Iterator”
- `Iterator` → iterates one-by-one
- `Spliterator` → can split the data into multiple parts (for parallel processing)
- Spliterator Introduction in java 1.8v
- Spliterator is an interface in collections api
- Spliterator supports-both serial & parallel programming
- Spliterator we can use to traverse both Collections & Streams
- Spliterator can't be used with Map implementation classes

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Krishna");
        names.add("Arjun");

        // Get Spliterator from List
        Spliterator<String> sp = names.spliterator();

        System.out.println("=== tryAdvance() Example ===");
        // Processes elements one-by-one
        while (sp.tryAdvance(n -> System.out.println("Name: " + n))) {
            // empty block → all work done in tryAdvance
        }

        // Create another Spliterator to demo splitting
        Spliterator<String> sp1 = names.spliterator();

        System.out.println("\n=== trySplit() Example ===");
        Spliterator<String> sp2 = sp1.trySplit(); // splits into two parts

        // sp1 handles first half
        System.out.println("Part 1:");
        sp1.forEachRemaining(n -> System.out.println(n));

        // sp2 handles second half
        System.out.println("Part 2:");
        if (sp2 != null) {
            sp2.forEachRemaining(n -> System.out.println(n));
        }
    }
}
```

`tryAdvance()`
```makefile
Name: Ram
Name: Shyam
Name: Krishna
Name: Arjun
```

`trySplit()`
```yaml
Part 1:
Ram
Shyam

Part 2:
Krishna
Arjun

```

---

# Java 8 Interview Questions (Most Frequently Asked)

### 1. What is Stream API? Why is it used?
**Short Answer:**
-> Stream API is used to process data (filter, map, sort, reduce).
It does NOT store data, only processes it.

---

### 2. Difference between Stream and Collection

| **Stream**                      | 	**Collection**       |
|-----------------------------|---------------------|
| Used to process data	       | Used to store data  |
| No modification of source   | Can modify          |
| Lazy evaluation	           | Not lazy            |
| Can be parallel	           | Always sequential   |

---

### 3. What is Intermediate vs Terminal Operation?

**Intermediate:** returns Stream → `filter()`, `map()`, `sorted()`

**Terminal:** returns result → `collect()`, `forEach()`, `count()`

---

### 4. What is `filter()`?

Used to filter data based on condition.

Example: `nums.stream().filter(n -> n > 10)`

---

### 5. What is `map()`?

Transforms data.

**Example:** convert to uppercase.

---

### 6. What is `reduce()`?

Combines elements to single result.

**Example:** sum.

---

### 7. Difference between `map()`and `flatMap()`

| `map()`	         | `flatMap()`                |
|-------------------|--------------------------|
| returns Stream<T> | returns Stream<flat>     |
| output = 1:1      | 	output = 1:many         |
| does not flatten  | 	flattens nested streams |

---

### 8. What is Optional? Why do we use it?

To avoid null pointer exception.

---

### 9. What is method reference?

(They often ask even if you won’t use it)

`ClassName::methodName` → shorthand for lambda.

---

### 10. What is Functional Interface?

Only ONE abstract method.

**Example:** Runnable, Callable, Predicate, Consumer, Supplier.

---

### 11. What are default & static methods in Interface?

Added in Java 8 to allow concrete methods in interfaces.

---

### 12. Explain Predicate, Consumer, Supplier

- **Predicate:** returns boolean
- **Consumer:** returns nothing
- **Supplier:** returns something (no input)

---

### 13. What is parallelStream()?

Runs tasks using multiple threads internally via ForkJoinPool.

---

### 14. Stream API vs Parallel Stream

Parallel stream processes elements in multiple threads → faster for large data.

---

### 15. What is Spliterator?

Advanced iterator used by Streams. Supports parallel traversal.

---

### 16. `collect()` → List, Set, Map

You must know:

- toList()

- toSet()

- toMap()

- joining()

- groupingBy()

- partitioningBy()

- counting()

- summingInt()

- averagingInt()

---

### 17. Difference between `groupingBy()` and `partitioningBy()`

| **groupingBy**      | 	 **partitioningBy**      |
|-----------------|-------------------------|
| multiple groups | 	only two groups      |
| based on key    | 	based on boolean     |
| Map<K, List<V>> | 	Map<Boolean, List<V>>|

---

### 18. What is lazy evaluation in Stream?

Intermediate ops run only when terminal op is applied.

---

### 19. Why Java 8 introduced lambda?

To write concise, functional-style code.

---

### 20. Can Stream be reused?

**NO.**
Stream = one time use.

---

# Practice Task For Interview's

### **You have a class Of Employee like this**

**1. Employee Class**
```java
class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    public Employee(int id, String name, int age, String gender,
                    String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public int getYearOfJoining() { return yearOfJoining; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}
```
**2. Employee List (Complete Data)**

```
List<Employee> employeeList = new ArrayList<>();

employeeList.add(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
employeeList.add(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
employeeList.add(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
employeeList.add(new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
employeeList.add(new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
employeeList.add(new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
employeeList.add(new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
employeeList.add(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
employeeList.add(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
employeeList.add(new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
employeeList.add(new Employee(11, "Gouii", 27, "Female", "Infrastructure", 2014, 15700.0));
employeeList.add(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
employeeList.add(new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
employeeList.add(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
employeeList.add(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
employeeList.add(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));
```

---

## 💻 Java 8 Stream Interview Questions (Employee-based)

These are industry-level, asked constantly.

## 📌 Core Stream Operations Questions

* 1. Count male and female employees.
* 2. Print the names of all departments.
* 3. Average age of male and female employees.
* 4. Highest-paid employee details.
* 5. Employees who joined after 2015.
* 6. Number of employees in each department.
* 7. Average salary of each department.
* 8. Youngest male employee in Development department.
* 9. Employee with the most years of experience (earliest joining year).
* 10. Count male and female employees in Sales department.
* 11. Average salary by gender.
* 12. List all employees in each department (Map<String, List<Employee>>).
* 13. What is the average salary in the organization?
* 14. Who is the oldest employee? Print name and department.
* 15. List employees sorted by salary (desc).
* 16. Group employees by gender → then find average salary inside each group.
* 17. Find the second highest salary employee.
* 18. List employee names who are above 30.
* 19. Partition employees whose salary > 20000.
* 20. Create a Map<department, count> without using groupingBy (use reduce()).



