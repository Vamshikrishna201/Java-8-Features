package v_8_Stream_API;

import java.util.*;
import java.util.stream.Collectors;

// Example of groupingBy()
//groupingBy operations nothing but categorizing the data
public class ex14_GroupingBy {
    public static void main(String[] args) {
        Emp e1 = new Emp(1, "Vamshi",500000.00 , "INDIA", "IT");
        Emp e2 = new Emp(2, "Goku",22000.00 , "JAPAN", "Accounts");
        Emp e3 = new Emp(3, "Wang",240000.00 , "CHINA", "Finance");
        Emp e4 = new Emp(4, "Ryotsu",38000.00 , "JAPAN", "IT");
        Emp e5 = new Emp(5, "Krishna",500000.00 , "INDIA", "HR");

        List<Emp> list = Arrays.asList(e1,e2,e3,e4,e5);

        // Task: check group of employee from country's
        Map<String, List<Emp>> data = list.stream()
                 .collect(Collectors.groupingBy( i -> i.country));
//        System.out.println(data);
        //In above example employee will be grouped based on country name.

        // Task: check group of employees names by there country
        Map<String, List<String>> empNames = list.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCountry(),
                    Collectors.mapping(emp -> emp.getName(),
                        Collectors.toList())));
//        System.out.println(empNames); //{CHINA=[Wang], JAPAN=[Goku, Ryotsu], INDIA=[Vamshi, Krishna]}

        // Task: sum total salary per department
        Map<String, Double> dep = list.stream()
                .collect(Collectors.groupingBy(i -> i.getDepartment(),
                        Collectors.summingDouble( emp  -> emp.getSalary())));
//        System.out.println(dep); //{Finance=240000.0, HR=500000.0, IT=538000.0, Accounts=22000.0}


        // Task: group the employee by department and Extract only their names inside each group.
        Map<String, Set<String>> depEmpNames = list.stream().collect(Collectors.groupingBy( emp -> emp.getDepartment(),
                Collectors.mapping(emp -> emp.getName(), Collectors.toSet())));
//        System.out.println(depEmpNames); //{Finance=[Wang], HR=[Krishna], IT=[Ryotsu, Vamshi], Accounts=[Goku]}

        //Task: Find the employee make salary in each department
        Map<String, Optional<Emp>> maxSalary = list.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                        Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
//        System.out.println(maxSalary);

        //Task: convert List into Set
        Map<String, Set<String>> toSet = list.stream()
                .collect(Collectors.groupingBy( e -> e.getDepartment(),
                    Collectors.mapping( emp -> emp.getName(),
                        Collectors.toSet())));
//        System.out.println(toSet);

        //Task: Find the Count of Employees Per Country
        Map<String,Long> countEmp =  list.stream()
                .collect(Collectors.groupingBy( c -> c.getCountry(),
                    Collectors.counting()));
//        System.out.println(countEmp);//{CHINA=1, JAPAN=2, INDIA=2}

        //Task: Calculate the Average Salary Per Department
        Map<String, Double> avgSalary = list.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                Collectors.averagingDouble( a -> a.getSalary())));
        System.out.println(avgSalary);






    }
}
