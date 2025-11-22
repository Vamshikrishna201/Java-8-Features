package v_8_Stream_API;


import java.util.stream.Stream;

class Users{
    String name;
    int age;
    Users(String name, int age){
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Name: " + name + " - Age: " + age;
    }
}
public class ex2_Stream {
    public static void main(String[] args) {
        //print users name starts with 'V' and age should be 18 above
        Users u1 = new Users("Vamshi", 24);
        Users u2 = new Users("Nikhil", 19);
        Users u3 = new Users("Rushi", 16);
        Users u4 = new Users("Mahesh", 25);
        Users u5 = new Users("Varad", 21);
        Users u6 = new Users("Rudra", 11);

        Stream<Users> usersDetail = Stream.of(u1,u2,u3,u4,u5,u6);

        //print users age under 20
//        usersDetail.filter( i -> i.age <= 20).forEach(i -> System.out.println(i));

        usersDetail
                .filter( i -> i.name.startsWith("V") && i.age >= 18)
                .forEach(i -> System.out.println(i));

    }
}
