package DP.CatalansNumber;

import java.util.*;;

public class Memoization {

    public static int catalanRec(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;

        for (int i = 0; i <= n - 1; i++) {
            ans += catalanRec(i, dp) * catalanRec(n - i - 1, dp);

        }

        dp[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanRec(n, dp));
    }
}
