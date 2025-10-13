package DP.WildcardMatching;

public class Tabulation {

    trupl// O(n *m)
    public static boolean wildcardMatching(String s, String p) {
        int n = s.length();
        int m = p.length();

        //HARD - classical
        boolean dp[][] = new boolean[n + 1][m + 1];

        // initialization
        dp[0][0] = true;
        // s = "abc", pattern = "_"
        for (int i = 1; i < n + 1; i++){
            dp[i][0] = false;
        }

        // s = "_" p="*?ajn"
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];  //true / false
            }
        }

        //bottom up

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case -> ith char == jth char || jth char == ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Empty || match
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    // s="ab", p = "de"
                    dp[i][j] = false;
                }
            }
        }

        //string  -> n, patten -> m
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "**?bd*";
        System.out.println(wildcardMatching(s, p));
    }
}   