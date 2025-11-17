package v3_Functional_Interfaces;

/*
-=-=-=-=-=-=-=-=-=-=-=-=-
    Predicate Joining
-=-=-=-=-=-=-=-=-=-=-=-=-
-> To combine multiple predicate we will use Predicate Joining

- and() method.
- or() method.

Task: Print employee name who are working in Hyd location in DB team
*/

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
KEY POINTS:
---------
Predicate is a Functional interface.
it contains one abstract method that is, boolean test(T t);
Use to check condition on an object and return a boolean result
 */
class Employee
{
    String name;
    String location;
    String dept;

    Employee(String name, String location, String dept) {
        this.name = name;
        this.location = location;
        this.dept = dept;
    }

    public String toString(){
        return "Name:"+name+ ", Dept:"+ dept+ ", Location:" + location;
    }
}
public class e4_Predicate_Joining {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vamshi", "Hyd", "DB");
        Employee e2 = new Employee("Parth", "Chandigarh", "Python");
        Employee e3 = new Employee("Shree", "Pune", "PHP");
        Employee e4 = new Employee("Saurabh", "Nashik", "DB");

        List<Employee> emp = Arrays.asList(e1, e2, e3, e4);

        Predicate<Employee> p1 = e -> e.location.equals("Hyd");
        Predicate<Employee> p2 = e -> e.dept.equals("DB");

        // Predicate Joining
        Predicate<Employee> p = p1.and(p2);

        for(Employee e : emp){
            if(p.test(e)){
                System.out.println(e.name);
            }
        }
    }
}
