public class Chocolate {
    class Solution {

        public int dfs(int r1, int c1, int r2, int c2, int dp[][][][], int mat[][]) {
            int n = mat.length, m = mat[0].length;

            // Invalid positions
            if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 ||
                    r1 >= n || c1 >= m || r2 >= n || c2 >= m ||
                    mat[r1][c1] == -1 || mat[r2][c2] == -1) {
                return Integer.MIN_VALUE;
            }

            // Base case — both reached bottom-right
            if (r1 == n - 1 && c1 == m - 1)
                return mat[r1][c1];

            // Memoized value
            if (dp[r1][c1][r2][c2] != -1)
                return dp[r1][c1][r2][c2];

            // Chocolates picked
            int chocolates = 0;
            if (r1 == r2 && c1 == c2)
                chocolates += mat[r1][c1];
            else
                chocolates += mat[r1][c1] + mat[r2][c2];

            // Explore all 4 move pairs
            int dd = dfs(r1 + 1, c1, r2 + 1, c2, dp, mat);
            int rr = dfs(r1, c1 + 1, r2, c2 + 1, dp, mat);
            int dr = dfs(r1 + 1, c1, r2, c2 + 1, dp, mat);
            int rd = dfs(r1, c1 + 1, r2 + 1, c2, dp, mat);

            // Best next step
            int bestNext = Math.max(Math.max(dd, rr), Math.max(dr, rd));

            // No valid path ahead
            if (bestNext == Integer.MIN_VALUE)
                return dp[r1][c1][r2][c2] = Integer.MIN_VALUE;

            chocolates += bestNext;

            return dp[r1][c1][r2][c2] = chocolates;
        }

        public int chocolatePickup(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            int dp[][][][] = new int[n][m][n][m];

            for (int[][][] a : dp)
                for (int[][] b : a)
                    for (int[] c : b)
                        Arrays.fill(c, -1);

            // Start from (0,0) for both
            int ans = dfs(0, 0, 0, 0, dp, mat);
            return Math.max(0, ans); // if no valid path exists, return 0
        }
    }
}


/*
 * Two people start at (0,0) and must both reach (n-1,m-1) while collecting the maximum chocolates without counting the same cell twice.

👣 Idea:
Both people move step by step together.
At any time:

Person 1 is at (r1, c1)

Person 2 is at (r2, c2)

Both have taken the same number of steps → r1 + c1 == r2 + c2

From there, they can each move Right or Down, giving 4 possible combinations.

🍫 What dfs returns:
dfs(r1, c1, r2, c2) → max chocolates collected by both starting from those two positions until reaching bottom-right.

If both are on the same cell → add chocolate once, else add both.
 */