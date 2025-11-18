package v3_Functional_Interfaces;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/* Function functional interface KeyPoints:-
- Function is pre-defined functional interface.
- It takes input and it returns output.
- Function interface having onw abstract method i.e `apply(T t)`
*/
class Employee1{
    int id;
    String name;
    int salary;

    public Employee1(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //To convert object address into string representation then we can use toString method
    //toString method from Object Class.
    @Override
    public String toString(){
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary;
    }
}

public class t2_Function {
    public static void main(String[] args) {

        //Take 5 employee from function and return only those employees whoes name starts with A
        Function<List<Employee1>, List<Employee1> > list = i ->{
            List<Employee1> emp = new ArrayList<Employee1>();
            for(Employee1 e:i){
                if(e.getName().startsWith("V")){
                    emp.add(e);
                }
            }
            return emp;
        };

        List<Employee1> apply = list.apply(Arrays.asList(new Employee1(1, "Ram", 450000),
                new Employee1(2, "Shyam", 550000),
                new Employee1(3, "Varun", 650000),
                new Employee1(4, "Vamshi", 750000),
                new Employee1(5, "Shivam", 850000)));
        System.out.println(apply);
    }
}
