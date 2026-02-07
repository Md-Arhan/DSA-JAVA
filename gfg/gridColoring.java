public class gridColoring {
    class Solution {

    int MOD = 1_000_000_007;
    Integer[][][][] dp;

    public int solve(int i, int n, int p1, int p2, int p3) {

        if (i == n) return 1;

        if (dp[i][p1+1][p2+1][p3+1] != null)
            return dp[i][p1+1][p2+1][p3+1];

        long ans = 0;

        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    if (p1 != c1 && p2 != c2 && p3 != c3 &&
                        c1 != c2 && c2 != c3) {

                        ans = (ans + solve(i+1, n, c1, c2, c3)) % MOD;
                    }
                }
            }
        }

        return dp[i][p1+1][p2+1][p3+1] = (int) ans;
    }

    public int numOfWays(int n) {
        dp = new Integer[n+1][4][4][4];

        return solve(0, n, -1, -1, -1);
    }
}
}
