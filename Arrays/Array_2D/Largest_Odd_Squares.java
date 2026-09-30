class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n + 1][m + 1];

        // Prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                dp[i][j] = mat[i - 1][j - 1]
                         + dp[i - 1][j]
                         + dp[i][j - 1]
                         - dp[i - 1][j - 1];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int q = 0; q < queries.length; q++) {

            int centerRow = queries[q][0];
            int centerCol = queries[q][1];

            int largest = -1;

            for(int side=1; ; side+=2){
                
                int radius = side / 2;
                int top = centerRow - radius;
                int left = centerCol - radius;
                
                int bottom = centerRow + radius;
                int right = centerCol + radius;
                
                if(top < 0 || left < 0 || bottom >= n || right >= m) break;
                
                int square_val = dp[bottom + 1][right+1] - dp[top][right+1] - dp[bottom+1][left] + dp[top][left];
                
                if(square_val <= k){
                    largest = side;
                }else{
                    break;
                }
            }

            ans.add(largest);
        }

        return ans;
    }
}