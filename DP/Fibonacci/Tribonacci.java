package DP.Fibonacci;

import java.util.Arrays;

public class Tribonacci {
    public static int tribonacci(int n, int dp[]){
        // if(n==0 || n==1){
        //     return n;
        // }

        // if (n<0) {
        //     return 0;
        // }

        if (n==0) {
            return 0;
        }

        if (n==1 || n==2) {
            return 1;
        }

        if (dp[n] != -1) {
           return dp[n];
        }

        dp[n] = tribonacci(n-1, dp) + tribonacci(n-2, dp) + tribonacci(n-3, dp);
        return dp[n];
     }
  
    public static void main(String[] args) {
        int n = 3;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(tribonacci(n, dp));

    }    
}
