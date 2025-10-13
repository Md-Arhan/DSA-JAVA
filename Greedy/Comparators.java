package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



//Custom Comparator for other object

// class Student {
//     private int id;
//     private String name;

//     public Student(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     @Override
//     // toString() method call implicitally when we dont call explicitally, This happens because the toString() method is the default way to convert an object to a string representation.
//     public String toString() {
//         return "Student{id=" + id + ", name='" + name + "'}";
//     }
    
// }

// public class Comparators {
//     public static void main(String[] args) {
//         List<Student> students = new ArrayList<>();
//         students.add(new Student(3, "Alice"));
//         students.add(new Student(1, "Bob"));
//         students.add(new Student(2, "Charlie"));

//         // Sort by Name (using an anonymous class)
//         Collections.sort(students, new Comparator<Student>() {
//             @Override
//             public int compare(Student s1, Student s2) {
//                 return s1.getName().compareTo(s2.getName());
//             }
//         });

//         System.out.println("Sorted by Name:");
//         for (Student student : students) {
//             System.out.println(student);
//         }
        
//         // Sort by Age using a Lambda Expression
//         students.sort((s1, s2) -> s1.getId() - s2.getId());   //Ascending Order
//         System.out.println("Sorted by Age:");
//         for (Student student : students) {
//             System.out.println(student.toString());
//         }

//         // Sort by Name using a Method Reference
//         students.sort(Comparator.comparing(Student::getName));
//         System.out.println("\nSorted by Name:");
//         for (Student student : students) {
//             System.out.println(student);
//         }

//         // Sort by Age, then by Name
//         students.sort(Comparator.comparingInt(Student::getId).thenComparing(Student::getName));
//         System.out.println("\nSorted by Age, then by Name:");
//         for (Student student : students) {
//             System.out.println(student);
//         }


//         //Comparator
//         List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

//         // Anonymous class for custom sorting
//         Collections.sort(names, new Comparator<String>() {
//             @Override
//             public int compare(String s1, String s2) {
//                 return s1.length() - s2.length(); // Sort by string length
//             }
//         });

//         System.out.println("Sorted by length: " + names);
    
//     }
// }



// Custom Comparator using Interface is in InterfaceComparator folder




//Comparabale in java


// class Student implements Comparable<Student> {
//     private String name;
//     private int age;

//     // Constructor
//     public Student(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     // Getters
//     public String getName() {
//         return name;
//     }

//     public int getAge() {
//         return age;
//     }

//     // Overriding compareTo() method  for int : 
//     // @Override
//     // public int compareTo(Student other) {
//     //     // Compare based on age (ascending order)
//     //     return Integer.compare(this.age, other.age);
//     // }

//     //for String name : 
//     // @Override   
//     // public int compareTo(Student other) {
//     //     // Compare based on name (lexicographical order)
//     //     return this.name.compareTo(other.name);
//     // }

//     //Comparing Both String and int :
//     @Override
//     public int compareTo(Student other) {
//         // Primary comparison: name
//         int nameComparison = this.name.compareTo(other.name);
//         if (nameComparison != 0) {
//             return nameComparison;
//         }
//         // Secondary comparison: age (if names are equal)
//         return Integer.compare(this.age, other.age);
//     }


//     @Override
//     public String toString() {
//         return "Student{name='" + name + "', age=" + age + "}";
//     }
    
// }

// public class Comparators {
//     public static void main(String[] args) {
//         // Create a list of students
//         ArrayList<Student> students = new ArrayList<>();
//         students.add(new Student("Alice", 22));
//         students.add(new Student("Bob", 20));
//         students.add(new Student("Charlie", 21));

//         // Sort the list using Collections.sort
//         Collections.sort(students);

//         // Print sorted list
//         System.out.println("Sorted students:");
//         for (Student student : students) {
//             System.out.println(student);
//         }
//     }
// }
