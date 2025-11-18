package v4_Method_Reference;

import java.util.function.Supplier;


// Constructor Reference - ClassName::new

//   When to use?
//-> When lambda is only doing, return new ClassName().
class Student {
    Student(){
        System.out.println("Student object created...");
    }
}
public class m4_ConstructorRef {
    public static void main(String[] args) {

        //Without method reference
        Supplier<Student> s1 = () -> new Student();

        //With method reference
        Supplier<Student> s2 = Student::new;

        Student obj = s2.get();
    }
}
