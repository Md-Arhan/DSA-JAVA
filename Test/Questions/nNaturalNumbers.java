package Test.Questions;

import java.util.*;

public class nNaturalNumbers {
    // first n natural number in for loop

    public static void nNatural() {

    // Sum of first n natural number
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int val = 1;
        int sum = 0;

        while (val <= n) {
            sum = sum + val;
            val++;
        }
        System.out.println(sum);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int fact = 0;

        for (int i = 1; i <= n; i++) {
            fact = fact + i;
        }
        System.out.println(fact);
    }

}
