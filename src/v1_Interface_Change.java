// Interface Example Demonstrating Abstract and Default Methods (Java 8+)
interface Vehicle {

    //  Abstract Method
    // - Has no body.
    // - Every class implementing this interface MUST override it.
    void start();

    //  Default Method
    // - Introduced in Java 8 to allow interfaces to have method bodies.
    // - Classes implementing the interface can use this as-is
    //   OR override it if they want their own version.
    default void clean() {
        System.out.println("Cleaning completed...");
    }
}

// Class implementing the Vehicle interface
class Car implements Vehicle {

    //  Mandatory implementation of abstract method
    // - 'start()' is abstract in the interface, so it MUST be implemented here.
    @Override
    public void start() {
        System.out.println("Car started...");
    }

    //  Optional override of default method
    // - This is NOT mandatory, but if we override,
    //   our class-specific logic runs instead of the default version.
    @Override
    public void clean() {
        System.out.println("Car cleaning completed...");
    }
}

// Main class to run the example
public class v1_Interface_Change {
    public static void main(String[] args) {

        //  Creating object of the implementing class
        Car c = new Car();

        //  Calling overridden default method
        // - Since Car overrides 'clean()', this version executes.
        c.clean(); // Output → Car cleaning completed...

        //  Calling implemented abstract method
        // - This method was required to be implemented by Car.
        c.start(); // Output → Car started...
    }
}
