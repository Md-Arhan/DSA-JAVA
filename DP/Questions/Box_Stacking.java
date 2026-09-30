package DP.Questions;

public class Box_Stacking {
    class Solution {
        int n;
        int[][] boxes; // 3n orientations: {h, w, l}
        int[][] memo;

        // i = current orientation index to consider
        // j = index of orientation already placed at the bottom (-1 if none)
        public int solve(int i, int j) {
            if (i == n)
                return 0;

            if (memo[i][j + 1] != -1)
                return memo[i][j + 1];

            int best = solve(i + 1, j);

            int h = boxes[i][0], w = boxes[i][1], l = boxes[i][2];

            boolean fits = (j == -1) ||
                    (boxes[j][1] > w && boxes[j][2] > l) ||
                    (boxes[j][1] > l && boxes[j][2] > w);

            if (fits) {
                best = Math.max(best, h + solve(0, i));
            }

            memo[i][j + 1] = best;
            return best;
        }

        public int maxHeight(int[] height, int[] width, int[] length) {
            int m = height.length;
            boxes = new int[3 * m][3];
            for (int k = 0; k < m; k++) {
                int a = height[k], b = width[k], c = length[k];
                boxes[3 * k] = new int[] { a, b, c }; // a as height
                boxes[3 * k + 1] = new int[] { b, a, c }; // b as height
                boxes[3 * k + 2] = new int[] { c, a, b }; // c as height
            }
            n = 3 * m;
            memo = new int[n + 1][n + 1];
            for (int[] row : memo)
                java.util.Arrays.fill(row, -1);
            return solve(0, -1);
        }

    }
}


/*    Index    Height    Width    Length
----------------------------------
  0        4         3        2
  1        3         4        2
  2        2         4        3
  3        6         5        4
  4        5         6        4
  5        4         6        5
  */