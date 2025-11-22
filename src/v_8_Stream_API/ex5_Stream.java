package v_8_Stream_API;

import java.util.stream.Stream;

class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}

//Task:- get emp name & age whose salary is >= 50,000 using Stream API.

//example - 3 - map()
public class ex5_Stream {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vamshi", 400000.00, 24);
        Employee e2 = new Employee("Mahesh", 24000.00, 26);
        Employee e3 = new Employee("Rushi", 52000.00, 28);
        Employee e4 = new Employee("Nikhil", 200000.00, 25);
        Employee e5 = new Employee("Harsh", 25000.00 ,28);
        Employee e6 = new Employee("Saurabh", 30000.00, 29);

         Stream<Employee> list =Stream.of(e1,e2,e3,e4,e5,e6);
        //stream.of() method will give the stream object

        // like this also
//        list.filter(s -> s.salary >= 50000.00)
//                .map(i ->"Name: " + i.name + ", Age: " + i.age + " Salary: " + i.salary)
//                .forEach(print -> System.out.println(print));

        // like this also
        list.filter(i -> i.salary >= 50000)
                .forEach(p -> System.out.println(p.name + " - " + p.age));

    }
}
