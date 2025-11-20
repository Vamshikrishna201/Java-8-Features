package v_6_Optional_Class;


import java.util.Optional;

//Safe chaining example using ofNullable + map
class Address {
    private String city;
    Address(String city){ this.city = city; }
    String getCity(){ return city; }
}

class Person {
    private Address address;
    Person(Address address){ this.address = address; }
    Address getAddress(){ return address; }
}

public class o1_Opt5 {
    public static void main(String[] args) {
        Person p = new Person(new Address("Hyderabad")); // try changing to new Person(null) or p = null

        String city = Optional.ofNullable(p)
                .map(Person::getAddress)   // may return null
                .map(Address::getCity)     // safe map chaining
                .orElse("Unknown City");

        System.out.println("City: " + city);
    }
}
