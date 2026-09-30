package DP.Questions;

import java.util.Arrays;

public class No_of_ways_cur_pizza {
    class Solution {

        final int MOD = 1_000_000_007;

        private long solve(int r, int c, int k, int n, int m, int suffix[][], long dp[][][]) {
            if (k == 1) {
                if (suffix[r][c] > 0) {
                    return 1;
                }

                return 0;
            }

            if (dp[r][c][k] != -1) {
                return dp[r][c][k];
            }

            long ans = 0;

            // Horizontal Cut
            for (int nr = r + 1; nr < n; nr++) {
                if (suffix[nr][c] == suffix[r][c]) {
                    continue;
                }
                ans = ans + solve(nr, c, k - 1, n, m, suffix, dp) % MOD;
            }

            // Vertical Cut
            for (int nc = c + 1; nc < m; nc++) {
                if (suffix[r][nc] == suffix[r][c]) {
                    continue;
                }
                ans = ans + solve(r, nc, k - 1, n, m, suffix, dp) % MOD;
            }

            return dp[r][c][k] = ans % MOD;
        }

        public int ways(String[] pizza, int k) {
            int n = pizza.length;
            int m = pizza[0].length();

            int corn_pizza[][] = new int[n][m];
            long dp[][][] = new long[n + 1][m + 1][k + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Arrays.fill(dp[i][j], -1);
                    if (pizza[i].charAt(j) == 'A') {
                        corn_pizza[i][j] = 1;
                    } else {
                        corn_pizza[i][j] = 0;
                    }
                }
            }

            int suffix_corn[][] = new int[n + 1][m + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    suffix_corn[i][j] = corn_pizza[i][j] + suffix_corn[i + 1][j] + suffix_corn[i][j + 1]
                            - suffix_corn[i + 1][j + 1];
                }
            }

            return (int) solve(0, 0, k, corn_pizza.length, corn_pizza[0].length, suffix_corn, dp) % MOD;
        }
    }
}


/* 
Think of suffix[r][c] as:
“How many apples exist in the pizza piece starting at (r, c) and extending to the bottom-right?”

The state solve(r, c, k) means:
“How many ways can I cut the remaining pizza—from (r,c) onward—into k pieces, with every piece containing at least one apple?”

The intuition for each cut:
A horizontal cut at nr gives away the top portion: rows r to nr - 1.
That top portion has an apple if
suffix[r][c] > suffix[nr][c].The full remaining pizza has more apples than the lower leftover pizza.

Then recursively cut the leftover pizza beginning at (nr, c) into k - 1 pieces.
Likewise for a vertical cut:
suffix[r][c] > suffix[r][nc] means the left portion being given away contains an apple.
Recurse on (r, nc).
A compact way to remember it:
At every cut, validate only the piece you give away; recursion guarantees the remaining piece eventually becomes valid too.

Base case:
When k == 1, there is no more cutting.
The remaining pizza is one valid piece only if it has at least one apple.
Why suffix sums?
They let you instantly know apple counts in every bottom-right remaining rectangle, so you can test whether a proposed cut removes at least one apple.

One small readability improvement: instead of checking equality,
if (suffix[nr][c] == suffix[r][c]) continue;
you can remember the intent more clearly as:
if (suffix[r][c] > suffix[nr][c]) {
    // the removed top piece has an apple
}
Same logic, but it reads like the actual condition.






For one DP state solve(r, c, k):
Horizontal loop:
for (int nr = r + 1; nr < n; nr++)
It can run up to n - 1 times → O(n).
Vertical loop:
for (int nc = c + 1; nc < m; nc++)
It can run up to m - 1 times → O(m).
Both loops run for the same state, so we add their work:
\[
O(n) + O(m) = O(n+m)
\]w
*/