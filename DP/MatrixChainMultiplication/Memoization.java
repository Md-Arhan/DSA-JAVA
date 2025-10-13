package DP.MatrixChainMultiplication;

import java.util.Arrays;

public class Memoization {
    
    public static int mcm(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;   //Single matrix case
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k, dp); // Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcm(arr, k + 1, j, dp); // Ai+1..aj +> arr[k] x arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }
        
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 }; // n = 5;
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(mcm(arr, 1, n - 1, dp));
    }
}


/*
 * What is the Matrix Chain Multiplication Problem?
You are given dimensions of matrices in an array arr[], where:
You have n matrices.
Matrix 𝑀𝑖 has dimensions:

Matrix multiplication is associative, so you can parenthesize in many ways.

For example:
If you have matrices A, B, C, D, you can do:
((AB)C)D
(A(BC))D
A((BC)D)
(AB)(CD)
etc.
Each way results in a different number of operations, and we want to find the minimum.


If there's only one matrix (say A), no multiplication is needed.
You try all possible places k to split the product between i and j:
 What is happening in the code?
At every step:
Divide the problem into two parts: A[i..k] and A[k+1..j]
Recursively compute the cost to multiply each part
Add the cost of multiplying the two resulting matrices
Keep the minimum of all such possible divisions
You keep doing this until each subproblem becomes just one matrix, which returns 0.

“This problem is about choosing the optimal way to parenthesize matrix multiplications. Because matrix multiplication is associative but not commutative, the order of multiplication matters in terms of cost.
I use recursion to try every possible way to split the matrices (from i to j), recursively solve left and right parts, and add the multiplication cost of combining them. The base case is when only one matrix remains — no multiplication is needed.
I track the minimum cost among all splits. This approach solves the problem using divide and conquer, and can be optimized later using memoization or dynamic programming.”
 */

/*
 * Why matrix count is 1 to n?
✨ Because each matrix is formed from two consecutive dimensions.
Multiply matrices M₁ to M₄ (i.e. A × B × C × D)
Internally, we use arr[i-1], arr[k], arr[j] to compute the multiplication cost
For example:
cost = arr[i-1] * arr[k] * arr[j];

 you include k = j, it would "cut" after the last matrix — which means the right part becomes empty, and there's no valid multiplication to do. That’s useless and even incorrect in terms of indexin
 */