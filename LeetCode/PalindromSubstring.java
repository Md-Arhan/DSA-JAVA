import java.util.Arrays;

public class PalindromSubstring {

    //1 way
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

    //2 way
    public boolean isPalindrome(int i, int j, String s, int dp[][]) {
    if (i >= j) return true;

    if (dp[i][j] != -1) {
        return dp[i][j] == 1;
    }

    if (s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1, s, dp)) {
        dp[i][j] = 1;
    } else {
        dp[i][j] = 0;
    }

    return dp[i][j] == 1;
}

    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){   //O(n2)
            Arrays.fill(dp[i], -1);
        }

        int start = 0;
        int end = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){   // O(n2)
                if(isPalindrome(i, j, s,  dp)){   // O(n)
                    if((j - i + 1) > end){
                       start = i;
                       end =  j-i+1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=start; i<start + end; i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
