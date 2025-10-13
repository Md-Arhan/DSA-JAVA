package DP.LongestCommonSubsequence;

public class Tabulation {

    //O(n*m)
    public static int Tabulations(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
               if (str1.charAt(i-1) == str2.charAt(j-1)) {
                  dp[i][j] = dp[i-1][j-1] +1;
               }else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
               }
            }
        }

        return dp[n][m];
    }
    
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(Tabulations(str1, str2, str1.length(), str2.length()));
    }
}
