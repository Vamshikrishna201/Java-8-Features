package v_8_Stream_API;


import java.util.List;

class Student{
    String name;
    List<String> subjects;
    public Student(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    List<String> getSubjects(){
        return subjects;
    }
}
public class ex8_flatMap {
    public static void main(String[] args) {
        /*
            With Java 9, several so-called collection factory methods have
            been added. List and Set interfaces have “of()” methods
            to create an empty or no-empty Immutable
            List or Set objects as shown below.
        */
        List<Student> students = List.of(
                new Student("Vamshi", List.of("Java", "DB")),
                new Student("Krishna", List.of("Math", "Python"))
        );

//        students.stream().map( n -> "Student Name:" +  n.name + " Subjects:-" + n.getSubjects())
//                .forEach( i -> System.out.println(i));

        students.stream()
                .flatMap( f -> f.getSubjects().stream())
                .forEach( p -> System.out.println(p));
    }
}
