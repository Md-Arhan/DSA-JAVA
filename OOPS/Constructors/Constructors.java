package Constructors;

class Student {
    String name;
    int roll;

    Student(String name) { // Parameterized Constructor
        this.name = name;
    }

    void setRollno(int rollNo) {
        this.roll = rollNo;
    }
}

public class Constructors {

    public static void main(String[] args) {
        Student s1 = new Student("Arhan");
        System.out.println(s1.name);
        s1.setRollno(5);
        System.out.println(s1.roll);
    }
}
