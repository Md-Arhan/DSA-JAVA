package DP.CatalansNumber;

public class Recurssion {

    public static int catalanRec(int n){
        if (n==0 || n==1) {
            return 1;
        }

        int ans = 0;

        for(int i=0; i<=n-1; i++){
            ans+= catalanRec(i) * catalanRec(n-i-1);

        }
        return ans;
    }

    public static long catalan(int n) {
        long[] catalan = new long[n + 1];

        // Base case
        catalan[0] = 1;

        // Fill the array using the recursive formula:
        // C(n) = sum of C(i) * C(n-1-i) for i = 0 to n-1
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(catalanRec(n));
    }
}



/*
Catalans are famous sequence of natural numbers that appears in combinational problems and often for counting ways.
It can naturally from Divide and Conquer , they count structures that can split into smaller independent substructures

This means:
To compute C_n, we divide it into C_i (left substructure) and C_{n-1-i} (right substructure), and multiply them because each left pairing can combine with each right pairing.

Intuition
Think of valid parentheses or binary tree structures:
When constructing a binary tree with n nodes:
Choose i nodes for the left subtree → C_i ways.
The rest (n - 1 - i) go to the right subtree → C_{n-1-i} ways.
Multiply them: total ways for that division is C_i * C_{n-1-i}.
This is repeated for all i from 0 to n-1.
➡️ You're dividing the problem into subproblems (i and n-1-i) and conquering each recursively.
 */