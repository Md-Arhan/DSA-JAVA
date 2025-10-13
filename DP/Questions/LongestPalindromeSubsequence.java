package DP.Questions;

public class LongestPalindromeSubsequence {
    public class practice_Session {

        public String longestPalindrome(String s) {
            int n = s.length();

            int dp[][] = new int[n][n];
            int left = 0;
            int right = 0;
            int ans = 1;

            // 1st length subString is always palindrome
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            // 2 length subString
            for (int i = 0; i + 1 < n; i++) {
                int start = i;
                int end = i + 1;

                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 1;
                    if (ans == 1) {
                        ans = 2;
                        left = start;
                        right = end;
                    }
                }
            }

            // 3rd length
            for (int len = 3; len <= n; len++) {
                // in general i+ len -1 < n
                for (int i = 0; i + len - 1 < n; i++) {
                    int start = i;
                    int end = i + len - 1;

                    if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1] == 1) {
                        dp[start][end] = 1;
                        if (len > ans) {
                            ans = len;
                            left = start;
                            right = end;
                        }
                    }
                }
            }
            String res = "";
            for (int i = left; i < right; i++) {
                res += s.charAt(i);
            }

            return res;
        }

        public static void main(String[] args) {

        }
    }

    public int isPalindrome(int left, int right, String s){
        int count = 0;
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left +1 >=2){
                count++;
            }
            left--;
            right++;
        }
        
        return count;
    }
    
    public int countPS(String s) {
        // code here
        int n = s.length();

        int count = 0;

        for(int i=0; i<n; i++){
            count+=isPalindrome(i, i, s);
            count+=isPalindrome(i, i+1, s);
        }
        
        return count;
    }

}
