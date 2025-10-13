package DP.StringConversion;

public class Tabulation {

    public static int minOperations(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        // DP table for LCS
        int[][] dp = new int[m + 1][n + 1];

        // Compute LCS using DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // Match -> Extend LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Skip character
                }
            }
        }

        int lcsLength = dp[m][n]; // Length of Longest Common Subsequence
        int deletions = m - lcsLength; // Remove extra chars from word1
        int insertions = n - lcsLength; // Add missing chars from word2

        // System.out.println(m);
        // System.out.println(n);

        // System.out.println(lcsLength);
        // System.out.println(deletions);
        // System.out.println(insertions);

        return deletions + insertions;
    }

    public static void main(String args[]){
        String str1 = "pear";
        String str2 = "sea";
        System.out.println(minOperations(str1, str2));
        // minOperations(str1, str2);
    }
}
