package DP.Questions;

public class UnCrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n+1][m+1];

        //base are 0 if any 1 of array is empty

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
}
