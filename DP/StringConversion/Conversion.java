package DP.StringConversion;

public class Conversion {
    int stringConversion(String X, String Y) {
        // code here
        int n = X.length();
        int m = Y.length();
        
        int dp[][] = new int[n+1][m+1];
        
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = X.charAt(i - 1);
            if (Character.isLowerCase(ch)) {
               dp[i][0] = dp[i - 1][0];
            } else {
              dp[i][0] = 0;
            }
        }

        
        //fill
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                char ch = X.charAt(i-1);
                int ch1 = Y.charAt(j-1);
                if(Character.toUpperCase(ch) == ch1){
                    if(Character.isLowerCase(ch)){
                        dp[i][j] = (dp[i-1][j-1] == 1 || dp[i-1][j] == 1) ? 1 : 0;
                    }else{
                        dp[i][j] = dp[i-1][j-1];
                    }
                }else{
                   if(Character.isLowerCase(ch)){
                       dp[i][j] = dp[i-1][j];
                   }else{
                       dp[i][j] = 0;
                   }
                }
            }
        }
        
        return dp[n][m];
    }
}
