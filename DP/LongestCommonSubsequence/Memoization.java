package DP.LongestCommonSubsequence;

import java.util.Arrays;

public class Memoization {
    
    //O(n*m)
    public static int lcs(String s1, String s2, int n, int m, int dp[][]){
        if (n==0 || m==0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] = lcs(s1, s2, n-1, m-1, dp) + 1;
            return dp[n][m];
        }else{
            int ans1 = lcs(s1, s2, n-1, m, dp);
            int ans2 = lcs(s1, s2, n, m-1, dp);
            dp[n][m] =  Math.max(ans1, ans2);
            return dp[n][m];
        }
    }
    
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int []row : dp){
             Arrays.fill(row, -1);
        }
 
        System.out.println(lcs(str1, str2, str1.length(), str2.length(), dp));
    }
}
