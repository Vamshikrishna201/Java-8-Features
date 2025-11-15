package v2_FunctionalProgramming_Lambda_Ex;
import java.util.*;


/*Practice Task:- 🫡🫡
List of Students with rollNo, Name and marks
requirement1: sort the Student based on the rollNo's
requirement2: sort the Student based on the marks's
requirement3: sort the Student based on the name's
* */
public class v6_Lambda_Expression {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Vamshi" , 62);
        Student s2 = new Student(4, "Keishna" , 97);
        Student s3 = new Student(6, "Bob" , 78);
        Student s4 = new Student(3, "Apan" , 56);
        Student s5 = new Student(7, "Deep" , 87);

        List<Student> l = new LinkedList();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);

        l.sort((a , b) -> { // sorting for id
            if(a.getId() > b.getId())
                return 1;
            else if(a.getId() < b.getId())
                return -1;
            else return 0;
        });

        l.sort((a , b) -> { // sorting for marks
            if(a.getMarks() > b.getMarks())
                return 1;
            else if(a.getMarks() < b.getMarks())
                return -1;
            else return 0;
        });

        // sorting for name
        l.sort((a, b)-> {
            return a.getName().compareTo(b.getName());
        });

        System.out.println(l);
    }
}

