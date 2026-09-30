class Solution {

    private int solve(int si, int piles[], int prefix[], int n, int m, int dp[][]) {

        // No piles left
        if (si >= n) {
            return 0;
        }

        // If we can take all remaining piles
        if (si + 2 * m >= n) {
            return prefix[n - 1] - (si == 0 ? 0 : prefix[si - 1]);
        }

        if (dp[si][m] != -1) {
            return dp[si][m];
        }

        int totalRemaining = prefix[n - 1] - (si == 0 ? 0 : prefix[si - 1]);

        int maxX = 2 * m;

        int ans = 0;

        // Try every possible X
        for (int x = 1; x <= maxX && si + x <= n; x++) {

            int opponent = solve(
                si + x,
                piles,
                prefix,
                n,
                Math.max(m, x),
                dp
            );

            int current = totalRemaining - opponent;

            ans = Math.max(ans, current);
        }

        return dp[si][m] = ans;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        // Prefix sum
        int prefix[] = new int[n];

        prefix[0] = piles[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + piles[i];
        }

        // dp[index][M]
        int dp[][] = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, piles, prefix, n, 1, dp);
    }
}

/* 
"I have these piles remaining. I can choose an X. Let me take those X piles. Now it's the opponent's turn. Let the opponent play optimally on whatever remains. Then I'll calculate how much I finally get."
*/