package DP.MatrixChainMultiplication.MCM_String;

public class memo {
    // Java program to find Optimal parenthesization using
// Memoization

import java.util.*;

class GfG {

    // Custom pair class where first value is matrix
    // multiplication order and second is optimal cost
    static class Pair {
        String first;
        Integer second;

        Pair(String first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair matrixChainOrderRec(int[] arr, int i, int j,
            Pair[][] memo) {

        // If there is only one matrix
        if (i == j) {
            String temp = "";
            temp += (char) ('A' + i);
            return new Pair(temp, 0);
        }

        // if the result for this subproblem is
        // already computed then return it
        if (memo[i][j].second != -1)
            return memo[i][j];

        int res = Integer.MAX_VALUE;
        String str = "";

        // Try all possible split points k between i and j
        for (int k = i + 1; k <= j; k++) {
            Pair left = matrixChainOrderRec(arr, i, k - 1, memo);
            Pair right = matrixChainOrderRec(arr, k, j, memo);

            // Calculate the cost of multiplying
            // matrices from i to k and from k to j
            int curr = left.second + right.second
                    + arr[i] * arr[k] * arr[j + 1];

            // Update if we find a lower cost
            if (res > curr) {
                res = curr;
                str = "(" + left.first + right.first + ")";
            }
        }

        // Return minimum cost and matrix multiplication
        // order
        return memo[i][j] = new Pair(str, res);
    }

    static String matrixChainOrder(int[] arr) {
        int n = arr.length;

        // Memoization array to store the results
        Pair[][] memo = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = new Pair("", -1);
            }
        }

        return matrixChainOrderRec(arr, 0, n - 2, memo).first;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };
        System.out.println(matrixChainOrder(arr));
    }
}}
