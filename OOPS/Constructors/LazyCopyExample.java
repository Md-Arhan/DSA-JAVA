package Constructors;

class Student {
    String name;
    int roll;
    int[] marks;
    boolean isCopied; // Flag to track modifications

    // Constructor
    Student(String name, int roll, int[] marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.isCopied = false;
    }

    // Lazy Copy Method
    void modifyMarks(int index, int newValue) {
        if (!isCopied) {
            // Convert to Deep Copy before modification
            marks = marks.clone();
            isCopied = true;
        }
        marks[index] = newValue; // Modify marks after deep copying
    }

    // Display Method
    void display() {
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}

public class LazyCopyExample {
    public static void main(String[] args) {
        int[] marksArray = { 90, 80, 70 };
        Student s1 = new Student("Arhan", 123, marksArray);
        Student s2 = new Student(s1.name, s1.roll, s1.marks); // Initially shallow copy

        System.out.println("Before Modification:");
        s1.display();
        s2.display();

        // Modifying s2 triggers deep copy
        s2.modifyMarks(1, 100);

        System.out.println("\nAfter Modification in s2:");
        s1.display(); // s1 remains unchanged
        s2.display(); // s2 is now deep copied and modified
    }
}

/*
 * Lazy Copy is a hybrid approach between Shallow Copy (SC) and Deep Copy (DC). 
 * It initially behaves like a shallow copy, but if any object modification is detected, it converts itself into a deep copy. 
 * This approach helps optimize memory usage while ensuring object independence when needed.
 */

/*
 * Output
 * Before Modification:
Marks: 90 80 70 
Marks: 90 80 70 

After Modification in s2:
Marks: 90 80 70 
Marks: 90 100 70 
 */


 /*
  * Initially, s2 shares marks with s1 (shallow copy).
When s2.modifyMarks(1, 100) is called, it first clones marks (creating a deep copy) and then modifies it.
s1 remains unchanged, proving that lazy copying works.
  */