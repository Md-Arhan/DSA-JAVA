package DP.WildcardMatching;

public class Memo {
        public static int rec(int i, int j, String s, String p, int n, int m, int dp[][]){
        if (i==n && j==m) {
            return 1;
        }

        if (i<n && j == m) {
            return 0;
        }

        if(i==n && j<m){
            while(j<m){
                if (p.charAt(j) != '*') {
                    return 0;
                }
                j++;
            }
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = rec(i+1, j+1, s, p, n, m, dp);
        }else{
           if (p.charAt(j) != '*') {
              return 0;
           }else{
               // Treating the jth char as an empty space
               if(rec(i, j+1, s, p, n, m, dp) == 1){
                  ans = 1;
               }else {
                  if (rec(i+1, j, s, p, ans, m, dp) == 1) {
                    ans = 1; 
                  }
               }
           }
        }

        dp[i][j] = ans;
        return ans;
    }

    public boolean isMatch(String s, String p){
        int n = s.length();
        int m = s.length();

        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        if(rec(0, 0, s, p, n, m, dp ) == 1){
           return true;
        }else{
            return false;
        }
    }

}
