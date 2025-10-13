package DP.ClimbingStairs;

import java.util.Arrays;

public class Memoization {

    //O(n)
    public static int climbingStairs(int n, int dp[]){
        if (n==0) {
            return 1;
        }else if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climbingStairs(n-1, dp) + climbingStairs(n-2, dp) + climbingStairs(n-3, dp);
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(climbingStairs(n, dp));

    }
}


//take less time compare to recursion  