package Arrays;

import java.util.*;

public class Basics {
    public static void main(String[] args) {

        // int marks[] = new int[50];
        // int Numbers[] = { 1, 2, 3 };
        // int moreNumbers[] = { 4, 5, 6 };

        // String fruits[] = { "Mango", "Apple", "Orange" };

        // Creating an Array
        int marks[] = new int[50];

        Scanner sc = new Scanner(System.in);
        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();
        sc.close();

        System.out.println(marks.length);

        System.out.println("Physics " + marks[0]);
        System.out.println("Maths " + marks[1]);
        System.out.println("Chemistry " + marks[2]);

        // Updating an Array
        // marks[2] = 40;
        // marks[1] = marks[1] + 10;
        // System.out.println("Chemistry " + marks[2]);
        // System.out.println("Maths " + marks[1]);

        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("Percentge " + percentage + "%");

    }
}
