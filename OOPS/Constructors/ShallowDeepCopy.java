package Constructors;

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Arhan";
        s1.roll = 123;
        s1.password = "abcd@123";
        System.out.println(s1.name);
        System.out.println(s1.roll);
        System.out.println(s1.password);
        s1.marks[0] = 122;
        s1.marks[1] = 123;
        s1.marks[2] = 124;
        // for(int i=0; i<3; i++){
        // System.out.print(s1.marks[i] + " ");
        // }
        // System.out.println();

        Student s2 = new Student(s1); // copy
        s1.marks[2] = 100;
        for (int i = 0; i < 3; i++) {
            System.out.print(s2.marks[i] + " ");
        }
        System.out.println();

    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // shallow Copy Constructor
    Student(Student s1){
    marks = new int[3];
    this.name = s1.name;
    this.roll = s1.roll;
    this.marks = s1.marks;

    }

    // deep copy Constructor
    // Student(Student s1) {
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     for (int i = 0; i < marks.length; i++) {
    //         this.marks[i] = s1.marks[i];
    //     }
    // }

    Student() {
        marks = new int[3]; // Non-Parameterized Constructors
        System.out.println("Constructor is called...");
    }

}

// public class ShallowDeepCopy {
// public static void main(String[] args) {
// Student s1 = new Student();
// s1.name = "Arhan";
// s1.roll = 123;
// s1.password = "abcd@123";
// s1.marks[0] = 122;
// s1.marks[1] = 123;
// s1.marks[2] = 124;

// System.out.println("Original Student (s1) Data:");
// System.out.println("Name: " + s1.name);
// System.out.println("Roll: " + s1.roll);
// System.out.println("Password: " + s1.password);
// System.out.print("Marks: ");
// for (int i = 0; i < 3; i++) {
// System.out.print(s1.marks[i] + " ");
// }
// System.out.println("\n");

// // Shallow Copy Example
// Student shallowCopy = new Student(s1, false); // false means shallow copy
// s1.marks[2] = 100; // Modify original marks

// System.out.println("Shallow Copy (SC) Student Data:");
// System.out.print("Marks after modifying s1.marks[2]: ");
// for (int i = 0; i < 3; i++) {
// System.out.print(shallowCopy.marks[i] + " ");
// }
// System.out.println("\n");

// // Deep Copy Example
// Student deepCopy = new Student(s1, true); // true means deep copy
// s1.marks[2] = 200; // Modify original marks again

// System.out.println("Deep Copy (DC) Student Data:");
// System.out.print("Marks after modifying s1.marks[2] again: ");
// for (int i = 0; i < 3; i++) {
// System.out.print(deepCopy.marks[i] + " ");
// }
// System.out.println();
// }
// }

// class Student {
// String name;
// int roll;
// String password;
// int marks[];

// // Constructor for Shallow Copy (SC) and Deep Copy (DC)
// Student(Student s1, boolean deepCopy) {
// marks = new int[3];
// this.name = s1.name;
// this.roll = s1.roll;

// if (deepCopy) {
// // Deep Copy: Create a new marks array and copy values manually
// this.marks = new int[s1.marks.length];
// for (int i = 0; i < marks.length; i++) {
// this.marks[i] = s1.marks[i];
// }
// } else {
// // Shallow Copy: Just copy the reference of marks array
// this.marks = s1.marks;
// }
// }

// // Default Constructor
// Student() {
// marks = new int[3];
// System.out.println("Constructor is called...");
// }
// }





/*
 * 1. Shallow Copy (SC)
 * A shallow copy only copies references to objects instead of creating new
 * ones.
 * This means if you modify an array inside one object, it will also change in
 * the copied object because both share the same memory reference.
 * 
 * Example Output (Shallow Copy)
 * Shallow Copy (SC) Student Data:
 * Marks after modifying s1.marks[2]: 122 123 100 // Changes reflected in
 * shallow copy
 */

/*
 * 2. Deep Copy (DC)
 * A deep copy creates a completely independent object.
 * It allocates new memory and copies values manually instead of just copying
 * references.
 * This ensures that changes in the original object do not affect the copied
 * object.
 * Example Output (Deep Copy)
 * java
 * Copy
 * Edit
 * Deep Copy (DC) Student Data:
 * Marks after modifying s1.marks[2] again: 122 123 100 // No change in deep
 * copy
 */