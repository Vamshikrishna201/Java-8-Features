# StringJoiner

- java.util.StringJoiner class introduced in java 1.8v.
- It is used to join multiple strings using a delimiter (like `,` or `-` or `|`).
- We can concat prefix and suffix while joining strings using StringJoiner.

Example use cases:
- Joining names with commas
- Creating CSV strings
- Generating SQL lists `(A, B, C)`
- Formatting logs

---

## Code Example (Only Delimiter)

```java
import java.util.StringJoiner;

public class Demo {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(","); // delimiter: comma

        sj.add("Ram");
        sj.add("Krishna");
        sj.add("Hari");

        System.out.println(sj.toString());
        // Output: Ram,Krishna,Hari
    }
}
```

---

## With Prefix and Suffix

This is where StringJoiner becomes more useful.

```java
import java.util.StringJoiner;

public class Demo {
    public static void main(String[] args) {

        StringJoiner sj = new StringJoiner(", ", "[", "]");

        sj.add("Java");
        sj.add("Python");
        sj.add("C");

        System.out.println(sj.toString());
        // Output: [Java, Python, C]
    }
}
```
- `, ` → delimiter
- `[` → prefix
- `]` → suffix

--- 

## Joining using merge()

You can combine two StringJoiners (both must have same delimiter).

```java
StringJoiner sj1 = new StringJoiner(", ");
sj1.add("A").add("B");

StringJoiner sj2 = new StringJoiner(", ");
sj2.add("C").add("D");

sj1.merge(sj2);
System.out.println(sj1);
// Output: A, B, C, D
```

---

## Real-World Example: CSV

```java
StringJoiner csv = new StringJoiner(",");

csv.add("101")
   .add("Vamshi")
   .add("Java Developer");

System.out.println(csv);
// Output: 101,Vamshi,Java Developer
```