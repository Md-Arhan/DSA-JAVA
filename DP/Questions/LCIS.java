package DP.Questions;

public class LCIS {
    class Solution {
    public int LCIS(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int ans = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[j] = ans + 1;
                    res = Math.max(dp[j], res);
                } 
                if (a[i] > b[j]) {
                    ans = Math.max(ans, dp[j]);
                }
            }
        }
        return res;
    }
}
}
