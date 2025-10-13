package DP.Questions;

import java.util.Arrays;

public class LongestIncreasingPath {
    public int longest(int matrix[][], int i, int j, int val, int dp[][]){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j] <= val){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int count = 0;

        int up = longest(matrix, i+1, j, matrix[i][j], dp);

        int down =  longest(matrix, i-1, j, matrix[i][j], dp);

        int right = longest(matrix, i, j+1, matrix[i][j], dp);

        int left = longest(matrix, i, j-1, matrix[i][j], dp);

        return dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int longest = 0;
        int dp[][] = new int[n][m];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int path = longest(matrix, i, j, -1, dp);
                longest = Math.max(longest, path);
            }
        }

        return longest;
    }
}
