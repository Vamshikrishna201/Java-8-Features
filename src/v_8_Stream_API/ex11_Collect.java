package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
//collect() - example-1
/*
collect() is simply a terminal operation used for converting
your stream back into some final data structure.

Stream -> process/process/process
Collect -> List/Set/Map/String/Count/Custom Object.

Collectors are used to collect the data from the stream

Collectors:-
	1. List -> Collectors.toList()
	2. Set  -> Collectors.toSet()
	3. Strings -> Collectors.joining(", ")
	4. Count elements -> Collectors.counting()
	5. Map  -> Collectors.toMap(keyMapper, valueMapper)
*/
public class ex11_Collect {
    public static void main(String[] args) {
        //Task:-1 Convert List of numbers list of squares
        List<Integer> list = Arrays.asList(2,3,4,5,6,7);
        List<Integer> number = list.stream()
                .map( i -> i*i)
                .collect(Collectors.toList());
        System.out.println("Square Numbers:- " + number);


        //TASK 2 — Get All Odd Numbers Into a Set
        List<Integer> n = Arrays.asList(4,5,6,7,8,2,1,7,8);
        Set<Integer> set = n.stream().filter(i -> i% 2 != 0)
                .collect(Collectors.toSet());
        System.out.println(set); //[1, 5, 7]


        //Task 3- convert list of names -> single string
        List<String> names = Arrays.asList(
                "Vamshi", "Akash", "Vijay",
                "Chintu", "Vaibhav", "Ajay",
                "Kiran", "Jasprit", "Parth",
                "Akash", "Krishna", "Sourabh",
                "Nikhil");
        String c = names.stream()
                        .filter(i -> i.startsWith("V"))
                        .collect(Collectors.joining(" - "));
        System.out.println(c);


        //Task 4 - Convert List<String> to Uppercase + Join With “ | ”
        List<String> str = Arrays.asList("Ram", "Krishna", "Hari");

        String result = str.stream()
                .map(i -> i.toUpperCase())
                .collect(Collectors.joining(" | "));
        //Collectors.joining does NOT return a List, it returns a String
        System.out.println(result);

        //Task 5 - Convert List<Integer> to List<String>
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        List<String> s = nums.stream()
                .map(i -> i.toString())
                .collect(Collectors.toList());
        System.out.println(s);


        //TASK 6 — Count Students by First Letter
        List<String> students = Arrays.asList("Vamshi", "Prem",
                "Vipul", "Pratik", "Vaibhav", "Soham");
        Map<Character, Long> count =
                students.stream()
                .collect(Collectors
                        .groupingBy(name -> name.charAt(0),   // (A) Group students by their FIRST CHARACTER, Example: 'S' → ["Sachin", "Soham"]
                                 Collectors.counting()				// (B) For each group created above,
                        ));									        // COUNT how many items are in that group.
        System.out.println(count);							        // Example: 'S' group size = 2


        //TASK 7 — Convert List<Employee> in to Map<id, name>
        List<Emp> emp = Arrays.asList(
                new Emp(1, "A", 45644, "INDIA", "IT"),
                new Emp(2, "B",45634, "CHINA", "Accounts"),
                new Emp(3, "C", 56756, "JAPAN", "Finance")
        );
        Map<Integer, String> mapEmp = emp.stream()
                .collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
        System.out.println(mapEmp);
    }
}

class Emp {
    //For Task 7
    int id;
    String name;
    double sal;
    String country;
    String department;

    public Emp(int id, String name, double sal, String country, String department) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.country = country;
        this.department = department;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary(){
        return sal;
    }
    public String getCountry(){
        return country;
    }
    public String getDepartment(){ return department; }

    @Override
    public String toString() {
        return "Emp [ID=" + id +
                ", Name=" + name +
                ", Salary=" + sal +
                ", Country=" + country +
                ", Department=" + department +
                "]";
    }

}

