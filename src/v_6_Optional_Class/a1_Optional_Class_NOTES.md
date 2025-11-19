# ⭐ Optional Class

---

### 1. What is Optional?
- Java 8 introduced the **Optional class** in the java.util.Optional package
- Optional class is used to avoid `NullPointerException` in the program
- Optional provides a container object, that may or may not hold a non-null value.

### 2. What is NullPointerException?
- When we perform some operation on `null` value, Java throws **NullPointerException**

*Example:*
```java
String name = null;
System.out.println(name.length()); // ⚠️ NullPointerException
```
- To avoid **NullPointerExceptions** we have to implement null check before performing operation on the Object
```java
String s = null;
if (s != null) {
    System.out.println(s.length());
};
```

Problem:
- Too many if (x != null) checks everywhere
- Code becomes ugly and hard to maintain

*Optional fixes this by giving a clean API instead of manual null checks.*

---
### 3. Creating Optional Objects

### 3.1 `Optional.of(value)`
- Use it ONLY when you are 100% sure the value is not null.

```java
Optional<String> opt = Optional.of("Vamshi");
```

Example: Correct usage

```java
public class OptionalOfExample {
    public static void main(String[] args) {
        String name = "Vamshi";

        Optional<String> opt = Optional.of(name);

        System.out.println(opt.get()); // Output: Vamshi
    }
}
```

❌ Example: Wrong usage (value is null → crashes)

```java
public class OptionalOfFailExample {
    public static void main(String[] args) {
        String name = null;

        // This will throw NullPointerException immediately
        Optional<String> opt = Optional.of(name);
    }
}
```

If value is null → throws exception immediately.

---

### 3.2 `Optional.ofNullable(value)`
- Use this when the value might be null.
```java
Optional<String> opt = Optional.ofNullable(possibleNullValue);
```

✔ Example: value not null
```java
public class OptionalOfNullableExample1 {
    public static void main(String[] args) {
        String city = "Hyderabad";

        Optional<String> opt = Optional.ofNullable(city);

        System.out.println(opt.get());   // Output: Hyderabad
    }
}
```

✔ Example: value is null

```java
public class OptionalOfNullableExample2 {
    public static void main(String[] args) {
        String city = null;

        Optional<String> opt = Optional.ofNullable(city);

        System.out.println(opt.isPresent());  // Output: false
        System.out.println(opt);              // Output: Optional.empty
    }
}
```

If name is null → produces an empty Optional.

---

### 3.3 `Optional.empty()`
- Represents an empty Optional.
```java
Optional<String> opt = Optional.empty();
```

✔ Example: Creating an empty Optional

```java
public class OptionalEmptyExample {
    public static void main(String[] args) {
        Optional<String> opt = Optional.empty();

        System.out.println(opt.isPresent());   // Output: false
        System.out.println(opt);               // Output: Optional.empty
    }
}
```

✔ Example: Using empty Optional with fallback

```java
public class EmptyWithFallback {
    public static void main(String[] args) {
        Optional<String> opt = Optional.empty();

        String result = opt.orElse("Default Value");

        System.out.println(result);  // Output: Default Value
    }
}
```
---

## 🌐REAL-WORLD EXAMPLES (This is what you asked for)

---

### **Example 1: Getting User Email For Database**
- Without Optional (old, risky code):
```java
String email = user.getEmail();   // may be null
if (email != null) {
sendEmail(email);
}
```
**With Optional:**

```java
Optional<String> emailOpt = Optional.ofNullable(user.getEmail());

emailOpt.ifPresent(email -> sendEmail(email));
```
**No null checks scattered around. Cleaner and intentional.**

---

### **Example 2: API Response (may or may not return data)**

```java
public Optional<Product> findProductById(int id) {
    Product p = database.find(id);
    return Optional.ofNullable(p);
}
```
Usage:
```java
findProductById(10)
    .ifPresent(product -> System.out.println(product.getName()));
```
---

### **Example 3: Fallback Values**
Old way:
```java
String city;
if (user.getCity() != null) {
    city = user.getCity();
} else {
    city = "Unknown";
}
```
**Optional way:**

```java
String city = Optional.ofNullable(user.getCity())
                      .orElse("Unknown");
```

---

### **Example 4: Chaining Operations Safely**
Old, messy:
```java
if (order != null) {
    Customer c = order.getCustomer();
    if (c != null) {
        Address a = c.getAddress();
        if (a != null) {
            System.out.println(a.getCity());
        }
    }
}
```
**With Optional:**
```java
Optional.ofNullable(order)
        .map(Order::getCustomer)
        .map(Customer::getAddress)
        .map(Address::getCity)
        .ifPresent(System.out::println);
```
**This is where Optional shines.**

---
## ⭐ (4) Checking and Using Optional Values

---
### ✅ `isPresent()` and `isEmpty()`
**Avoid using these unless absolutely needed.**

They bring back the old `if(value != null)` style.

```java
Optional<String> opt = Optional.ofNullable(name);

if (opt.isPresent()) {
    System.out.println(opt.get());
}
```
Better approach: use `ifPresent()`

---

### ✅ `ifPresent()`
Runs code **only when value exists.**
```java
Optional<String> opt = Optional.of("Vamshi");

opt.ifPresent(value -> System.out.println("Name: " + value));
```
**Clean. Null-safe. No useless if conditions.**

---
### ✅ `ifPresentOrElse()`
Useful when you want action for both present and empty cases.
```java
Optional<String> opt = Optional.empty();

opt.ifPresentOrElse(
    value -> System.out.println(value),
    () -> System.out.println("No value found")
);
```
---

## ⭐ (5) Transforming Optional Values

---

### ✅ `map()` — apply a transformation
Use `map` when you want to transform the value if it exists.

Example: get the length of a username.
```java
Optional<String> nameOpt = Optional.of("Vamshi");

Optional<Integer> lengthOpt = nameOpt.map(String::length);

System.out.println(lengthOpt.get()); // 6
```
---

### ✅ `flatMap()` — when map returns another Optional
Real use: chaining repository/database calls.

Example: get a user's address inside optional User:
```java
Optional<User> userOpt = getUserById(10);

Optional<Address> addressOpt =
        userOpt.flatMap(User::getAddressOptional);
```
map creates `Optional<Optional<Address>>`, which is useless
`flatMap` fixes that.

---

## ⭐ (6) Default/Fallback Values

### ✅ `orElse()`
Returns a fallback value if Optional is empty.
```java
String city = Optional.ofNullable(user.getCity())
                      .orElse("Unknown");
```
**🔥 IMPORTANT TRUTH:**
`orElse()` always evaluates its argument, even if Optional has a value.
If the fallback is a heavy object → performance waste.

---

### ✅ `orElseGet()` — better version
`orElseGet()` uses a supplier → executed only if optional is empty.
```java
String city = Optional.ofNullable(user.getCity())
                      .orElseGet(() -> fetchDefaultCity());
```
**Use this for expensive fallback logic.**

---

### ❌ `orElseThrow()`
Throws an exception if empty.
```java
String email = Optional.ofNullable(user.getEmail())
                       .orElseThrow(() -> new RuntimeException("Email missing"));
```
Useful in APIs where missing value is not acceptable.

---

## ⭐ (7) Bad Uses of Optional (Don’t do these)
**❌ 1. Don’t use Optional for fields in POJO/entity classes**
Bad:
```java
class User {
    Optional<String> name; // WRONG
}
```
It bloats memory and makes serialization painful.

---

**❌ 2. Don’t use Optional in method parameters**
Bad:
```java
void setName(Optional<String> name); // NO
```
It confuses callers. Pass a normal value.

---

**❌ 3. Don’t use Optional everywhere**
Optional is perfect for:
- return types
- avoiding null checks
- chaining transformations

But don’t overdo it. Use Optional only where a value may realistically be missing.

---

## ⭐ FINAL Real-World Example: Complete Flow

Here’s something that actually happens in projects:

**Scenario**
You want to fetch a user → then fetch their email → and send a notification if email exists.

Without Optional (ugly):
```java
User user = repo.findUser(id);
if (user != null) {
    String email = user.getEmail();
    if (email != null) {
        notifier.send(email);
    }
}
```
With Optional (clean, readable, null-safe):
```java
Optional.ofNullable(repo.findUser(id))
        .map(User::getEmail)
        .ifPresent(notifier::send);
```
This is what Optional was designed for.

---

## 🔥 PRACTICE TASKS — Optional (Java 8)

### Task 1: Convert Null Check Code to Optional
You’re given this old-style code:
```java
String username = user.getUsername();
if (username != null) {
    System.out.println(username.toUpperCase());
} else {
    System.out.println("Guest");
}
```
👉 Rewrite this using Optional, no `if (opt.isPresent()).`

---

### Task 2: Safe Chaining
You have these methods:
```java
Order getOrder(int id)  
Customer Order.getCustomer()  
Address Customer.getAddress()  
String Address.getCity()
```
Any of them may return null.

👉 Print the city name using **Optional chaining.**

---

### Task 3: Optional Map

You receive an Optional containing a product name:
```java
Optional<String> p = Optional.of("Laptop");
```
👉 Get the length of the name using `map().`

---

### Task 4: Fallback Logic
Write code to get the user’s email:
- If email exists → return email.
- If not → return "no-email@domain.com".
Use either `orElse()` or `orElseGet()`, but pick the correct one.

---

### Task 5: Convert Method Return Type
Rewrite this method to return Optional:
```java
public String findCity(User user) {
    if (user == null) return null;
    if (user.getAddress() == null) return null;
    return user.getAddress().getCity();
}
```
👉 Convert into a clean Optional version.

---

### Task 6: ifPresentOrElse
You have an Optional age:
```java
Optional<Integer> age = Optional.ofNullable(someValue);
```
👉 Print:
- "Valid Age" if age is present
- "Age Missing" if empty

No if/else allowed.
---

### Task 7: Bad Practice Fixing

This is bad code:

```java
class User {
    Optional<String> name;
}
```
👉 Fix it and explain why the old code is wrong (1-line explanation).

---

### Task 8: Real-World Scenario
A service returns:
```java
Optional<Product> productOpt = productService.getProductById(id);
```
Your job:
👉 Print the product price ONLY if the product exists
(and don’t call `get()` blindly).

---

### Task 9: Optional + Stream
You have a list of Optional integers:
```java
List<Optional<Integer>> list = Arrays.asList(
    Optional.of(10),
    Optional.empty(),
    Optional.of(30)
);
```
👉 Extract all real integer values into a List<Integer> using stream.

---

### Task 10: Throw Exception If Missing
You must get the user token:
```java
String token = maybeToken(); // may return null
```
👉 Wrap this with Optional and throw a custom `TokenMissingException` if null.
