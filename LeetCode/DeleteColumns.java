package LeetCode;

public class DeleteColumns {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int n = strs.length;
            int m = strs[0].length();

            boolean[] sorted = new boolean[n - 1];
            int deletions = 0;

            for (int col = 0; col < m; col++) {
                boolean deleteCol = false;

                for (int row = 0; row < n - 1; row++) {
                    if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                        deleteCol = true;
                        deletions++;
                        break;
                    }
                }

                if (deleteCol)
                    continue;

                for (int row = 0; row < n - 1; row++) {
                    if (!sorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                        sorted[row] = true;
                        break;
                    }
                }
            }

            return deletions;
        }
    }
}


/*

Rewriting YOUR statement correctly

Here’s your statement rewritten accurately:

We check columns from left to right.
For each column, we compare unresolved row pairs.
If a column causes any wrong comparison (>), we delete it.
If a column helps decide correct order (<), we lock that row pair.
Already locked pairs are ignored in later columns.

✔️ THIS is the exact logic
*/