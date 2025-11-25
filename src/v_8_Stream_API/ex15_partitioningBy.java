package v_8_Stream_API;

import java.util.*;
import java.util.stream.Collectors;

//partitioningBy -> It takes a Predicate (a function that returns true or false).

//NOTE:-> it Always creates a Map with a Boolean Key:- Map<Boolean, List<T>>

// true Key: Holds a List of all elements that match the condition.
// false Key: Holds a List of all elements that do not match the condition.

public class ex15_partitioningBy {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7);

        //TASK-1 check even numbers from List of arrays
        Map<Boolean, List<Integer>> even = num.stream()
                .collect(Collectors.partitioningBy( i -> i % 2==0));
        System.out.println(even);//{false=[1, 3, 5, 7], true=[2, 4, 6]}

        //TASK2 count even & odd numbers.
        Map<Boolean, Long> count = num.stream()
                .collect(Collectors.partitioningBy( n -> n % 2==0,
                        Collectors.counting()));
        System.out.println(count);//{false=4, true=3}

        //TASK-3 sum even vs odd numbers.
        Map<Boolean, Integer> sumMap =
                num.stream()
                .collect(Collectors.partitioningBy(n -> n % 2==0,
                        Collectors.summingInt(n -> n)));
        System.out.println(sumMap);//{false=16, true=12}

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        List<Emp> emp = Arrays.asList(
        new Emp(1, "Vamshi",500000.00 , "INDIA", "IT"),
        new Emp(2, "Krishna",22000.00 , "INDIA", "Contractor"),
        new Emp(3, "Jay",240000.00 , "INDIA", "Marketing"),
        new Emp(4, "John",18000.00 , "US", "Finance"),
        new Emp(5, "Parth",26000.00 , "INDIA","Sales")
        );
        //TASK-4 separate employees by department or gender → return only names.
        Map<Boolean, Set<String>> seprateEmp = emp.stream()
                .collect(Collectors.partitioningBy(e -> e.getDepartment().equals("IT"),
                        Collectors.mapping( n -> n.getName(),
                                Collectors.toSet())));;
        System.out.println(seprateEmp);//{false=[Parth, Krishna, Jay, John], true=[Vamshi]}

        //TASK-5 : highest salary among of Employee
        Map<Boolean, Optional<Emp>> highSal = emp.stream()
                .collect(Collectors.partitioningBy(n->n.getDepartment().equals("IT"),
                Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
        System.out.println(highSal);

        //Task-6 Partition Employees → Salary >= 60k
        Map<Boolean, List<Emp>> result =
                emp.stream()
                        .collect(Collectors.partitioningBy(e -> e.getSalary() >= 35000));
        System.out.println(result);

    }
}
