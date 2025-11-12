## Interface Changes

---
-> An interface is a collection of abstract methods (methods without a body).

> `Note:` A method that does not have a body is called an abstract method.

**-> A class can implements interface**.

-> When a class is **implementing an interface** it is mandatory for
**that class to provide implementations for all the abstract methods**
declared in the interface.

Otherwise, the class will not compile.

---

-> Here im taking an interface with one abstract method.

All the classes that implement this interface must override its abstract method.

`Example:-`
```java
interface Vehicle {
    void startVehicle();  // abstract method
}

class Car implements Vehicle {
    public void startVehicle() {
        // logic to start car
    }
}

class Bus implements Vehicle {
    public void startVehicle() {
        // logic to start bus
    }
}
```
---

> **Important**
>
> If a new method is added to the Vehicle interface, all classes(Car,But etc.) that implement this interface must also implement the new method
>
> Otherwise, they will fail to compile.

--- 

### Key Points About Default and Static Methods in Interfaces (Java 8+)

1. **Interfaces can have concrete methods** starting from **Java 8**.
2. These concrete methods must be declared as either **`default`** or **`static`**.
3. **Default methods** can be **overridden** in the implementing classes.
4. **Static methods** **cannot** be overridden in implementing classes.
5. You can define **multiple default and static methods** inside an interface.
6. **Default and static methods** were introduced to provide **backward compatibility** — allowing new methods to be added to interfaces **without breaking existing implementations**.

---

**Example:-**

In Java 8, the `forEach()` method was added as a **default method** in the `java.lang.Iterable` interface.

---

### Default Methods in Interfaces

Introduced in **Java 8**, a **default method** allows interfaces to have methods with a **body (implementation)** using the `default` keyword.

---

### Example

```java
interface Vehicle {
    void start();  // abstract method

    default void clean() {   // default method
        System.out.println("Cleaning completed...");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started...");
    }
}

public class V1_Interface_Change {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();   // calls Car's implementation
        c.clean();   // calls default method from interface
    }
}
```
### 💡 Why Use Default Methods?

- To add new functionality to existing interfaces
  -> without breaking the classes that already implement them.
- Before Java 8, adding a new method forced every implementing class to update its code.
- With default methods, you can safely evolve interfaces while keeping old code working.

---

### Static Methods in Interfaces

Introduced in **Java 8**, interfaces can also have **static methods**.  
A **static method** in an interface belongs **to the interface itself**, not to the objects (classes) that implement it.

---

### Example

```java
interface Vehicle {
    void start();  // abstract method

    default void clean() {   // default method
        System.out.println("Cleaning completed...");
    }

    static void service() {  // static method
        System.out.println("Vehicle servicing...");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started...");
    }
}

public class V2_Interface_Static {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();    // calls Car's implementation
        c.clean();    // calls default method from interface

        Vehicle.service();  // calls static method using interface name
    }
}
```

### Key Points

### Static Methods in Interfaces

- **Not inherited** by implementing classes.  
- Must be called using the **interface name**, e.g.: `Vehicle.service();`
- Are mainly used for utility or helper methods related to the interface.
- They help organize related static functionality inside the interface itself, rather than in separate utility classes.
