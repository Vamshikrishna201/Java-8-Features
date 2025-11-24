package v_8_Stream_API;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//maxBy, minBy, averagingInt, averagingLong, averagingDouble

//all are Terminal Operations because they produce a single final result
// instead of returning a new stream.
public class ex13_Collect {
    public static void main(String[] args) {
        Emp e1 = new Emp(1, "Vamshi",500000.00 , "INDIA", "IT");
        Emp e2 = new Emp(2, "Mahesh",22000.00 , "INDIA", "Contractor");
        Emp e3 = new Emp(3, "Rushi",240000.00 , "INDIA", "Marketing");
        Emp e4 = new Emp(4, "Harsh",18000.00 , "INDIA", "Finance");
        Emp e5 = new Emp(5, "Saurabh",26000.00 , "INDIA","Sales");

        List<Emp> e = Arrays.asList(e1,e2,e3,e4,e5);

        //WAP to get Max, MIN and AVG salary from given employee data using Stream API
        Optional<Emp>  max = e.stream()
                        .collect(Collectors.maxBy(Comparator.comparing( s -> s.getSalary())));
        System.out.println("Emp Name: " + max.get().getName() + ", MAX Salary: "+ max.get().getSalary());

        Optional<Emp>  min = e.stream()
                .collect(Collectors.minBy(Comparator.comparing( s -> s.getSalary())));
        System.out.println("Emp Name: " + min.get().getName() + ", MIN Salary: "+ min.get().getSalary());

       Double avg = e.stream()
               .collect(Collectors.averagingDouble(i -> i.getSalary()));
        System.out.println("Emp:Name: " + min.get().getName() +", AVG Salary: "+avg);


    }
}
