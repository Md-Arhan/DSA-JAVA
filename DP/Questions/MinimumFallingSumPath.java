package DP.Questions;

public class MinimumFallingSumPath {

    public static int rec(int i, int j, int n, int m, int matrix[][], int dp[][]){
        if (i==n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE; 
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (i+1 < n) {
            down = matrix[i][j] + rec(i+1, j, n, m, matrix, dp);
        }

        if (j-1 >0) {
            left =matrix[i][j] + rec(i+1, j-1, n, m, matrix, dp);
        }
        
        if (j+1 < m) {
            right = matrix[i][j] + rec(i+1, j+1, n, m, matrix, dp);
        }

        int ans = Math.min(left, Math.min(right, down));

        return ans;
    }

    public int fallingSumPath(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int mi = Integer.MAX_VALUE;
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        for(int j=0; j<m; j++){
            mi = Math.min(mi, rec(0, j, n, m, matrix, dp));
        }

        return mi;
    }
    
    public static void main(String args[]){

    }
}


/* check Screenshot */