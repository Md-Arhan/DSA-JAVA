package DP.TargetSumSubset;

public class Tabulation {   //derivative question

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // O(n*target)
    public static boolean tabulation(int arr[], int target) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][target + 1];

        // i = items & j = target
        /*
         * Why dp[i][0] = true?
         * Setting dp[i][0] = true (or row[0] = 1) ensures that a subset with sum 0 is
         * always possible, because we can achieve a sum of 0 by selecting no elements
         * from the array.
         * 
         * Example: If the array is {3, 4, 5}, we can always have an empty subset {}
         * that sums to 0, so dp[i][0] = true for all i.
         * 
         * Why dp[0][j] = false?
         * Setting dp[0][j] = false (or col[0] = 0) means that if we have no elements
         * available, then any nonzero target sum is impossible.
         * 
         * Example: If we try to form a sum j = 5 using an empty set {}, it’s
         * impossible, so dp[0][j] = false for all j > 0.
         * 
         */
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                /*
                 * If dp[i-1][j] == true, it means that we could already achieve j using only
                 * the previous elements, so we don't need to include arr[i-1].
                 * Simple Explanation:
                 * dp[i-1][j] == true means that using the previous i-1 elements, we have
                 * already found a subset that sums to j.
                 * If that’s the case, we don’t need to include arr[i-1] because the subset sum
                 * is already possible.
                 * So, we simply carry forward this true value to dp[i][j].
                 */
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        print(dp);
        return dp[n][target];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        System.out.println(tabulation(arr, target));
    }
}

/*
 * Why Do We Need the "Exclude" Condition?
 * Case When We Should Exclude:
 * 
 * Suppose arr = {4, 2, 7, 1, 3} and target = 10.
 * When we process arr[2] = 7, we must check if 10 can be formed without using
 * 7.
 * If it was already possible using {4, 2, 1, 3}, we should keep dp[i][j] = true
 * without using 7.
 * Avoid Overwriting a Possible Solution:
 * 
 * If we only rely on "include", some values might be wrongly marked as false
 * when they were true in a previous row.
 */