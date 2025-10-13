package Constructors;

public class TypesOfConstructors {

    public static void main(String[] args) {
        Student s1 = new Student(); // Non-Parameterized Constructors
        Student s2 = new Student("Arhan"); // Parameterized Constructors
        System.out.println(s1);
        System.out.println(s2.name);
        Student s3 = new Student(123); // Parameterized Constructors
        System.out.println(s3.roll);
        // Student s4 = new Student("Arhan", 123); //Error java doesn't take do diff
        // params

    }
}

class Student {
    String name;
    int roll;

    Student() { // Non-Parameterized Constructors
        System.out.println("Constructor is called...");
    }

    Student(String name) { // Parameterized Constructors
        this.name = name;
    }

    Student(int rollNo) { // Parameterized Constructors
        this.roll = rollNo;
    }
}
