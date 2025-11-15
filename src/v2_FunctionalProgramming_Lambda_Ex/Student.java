package v2_FunctionalProgramming_Lambda_Ex;
//this file for v6_Lambda_Expression
public class Student {
    int id;
    String name;
    private int marks;

    //Constructor
    Student(int id, String name, int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    // getter and setters
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getMarks(){
        return marks;
    }


    @Override
    public String toString() {
        return "\nStudent- "+ "Name:" +name + ", ID:"  +id + ", Marks:" +marks;
    }
}
