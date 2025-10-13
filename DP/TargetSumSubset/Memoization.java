package DP.TargetSumSubset;

import java.util.Arrays;

public class Memoization {

    public static boolean recurssion(int arr[], int target, int n, boolean dp[][]) {

        if (n == 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (dp[n][target] != false) {
            return dp[n][target];
        }

        int v = arr[n];

        if (v <= target) {
            if (recurssion(arr, target - v, n - 1, dp)) {
                dp[n][target] = true;
                return true;
            }
        }

        dp[n][target] = recurssion(arr, target, n - 1, dp);
        return dp[n][target];

    }

    class Solution {
        int count = 0;
        int increment;

        public int find(int n, int nums[], int target, int sum, int dp[][]) {
            if (n == -1) {
                if (sum == target) {
                    count++;
                    return 1;
                }
                return 0;
            }

            if (dp[n][sum + increment] != -1) {
                return dp[n][sum + increment];
            }

            int add = find(n - 1, nums, target, sum + nums[n], dp);

            int sub = find(n - 1, nums, target, sum - nums[n], dp);

            return dp[n][sum + increment] = add + sub;

        }

        public int findTargetSumWays(int[] nums, int target) {
            count = 0;
            increment = 0;
            int n = nums.length;
            int sum = 0;

            for (int ele : nums)
                increment += ele;

            int dp[][] = new int[nums.length + 1][2 * increment + 1];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }

            return find(n - 1, nums, target, sum, dp);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        int n = arr.length - 1;
        boolean dp[][] = new boolean[n + 1][target + 1];
        System.out.println(recurssion(arr, target, n, dp));
    }
}

/*
**count: tracks the number of valid combinations. (Though in your current logic, it’s not actually needed.)
increment: used to shift negative values of sum to valid positive indices in the dp[][] array. Since sum can range from -totalSum to +totalSum, we shift everything by +totalSum so all indices are ≥ 0.
If you've considered all elements (n == -1) and sum == target, you've found a valid way.
Return 1 if it's valid, else return 0.

Avoid recalculating if result is already stored.

sum + increment is used to avoid negative indices.

Try both +nums[n] and -nums[n] at each step.

Explore all possible combinations using recursion.

Total number of ways from this state is sum of the two recursive branches.

Store the result in dp for memoization.
*/