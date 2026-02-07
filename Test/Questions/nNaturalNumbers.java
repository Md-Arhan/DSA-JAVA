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


// A natural number is a postive number use to calculated the sum of those number in order


/*
| Expression           | Meaning                                      |
| -------------------- | -------------------------------------------- |
| ( \frac{n(n-1)}{2} ) | choose 2 from (n) (pairs / combinations)     |
| ( \frac{n(n+1)}{2} ) | sum of first (n) numbers (triangular number) |


🧩 1️⃣ 
n(n−1)
 — “Number of Unique Pairs” (Combinations)

This expression counts:

How many unordered pairs can be formed from 
𝑛
n distinct items?

Formally, it is the combination:


2️⃣ n(n+1)

 — “Sum of First 
𝑛
n Natural Numbers” 
*/