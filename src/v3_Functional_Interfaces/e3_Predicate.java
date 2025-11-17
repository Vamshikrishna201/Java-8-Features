package v3_Functional_Interfaces;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person {
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String  toString(){
        return "Name:" +name + " Age:" + age;
    };
}
/*
KEY POINTS:
---------
Predicate is a Functional interface.
it contains one abstract method that is, boolean test(T t);
Use to check condition on an object and return a boolean result
*/
public class e3_Predicate {
    /* Task 2:
    Take list of Persons and print persons whose age is >= 18 using lambda expression
     */
    public static void main(String[] args) {
        Person p1 = new Person(24, "Vamshi");
        Person p2 = new Person(25, "Rushi");
        Person p3 = new Person(28, "Tushar");
        Person p4 = new Person(12, "Rudra");
        Person p5 = new Person(16, "Krishna");
        //example-5
        List<Person> ps = Arrays.asList(p1, p2, p3, p4, p5);
        Predicate<Person> predicate = p -> p.age >= 18;

        for(Person person : ps){
            if(predicate.test(person)){
                System.out.println(person);
            }
        }
    }
}
