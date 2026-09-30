class Solution {

    int[] digits;
    int d;
    long[][][] dp;

    public int countWithout(int n, int d) {

        if (n == 0) return 0;

        this.d = d;

        String s = String.valueOf(n);

        digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        dp = new long[11][2][2];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // 0 is counted, but we only want 1 to n
        return (int)(solve(0, 1, 0)-1);
    }

    private long solve(int pos, int tight, int started) {

        if (pos == digits.length) {
            return 1;
        }

        if (dp[pos][tight][started] != -1) {
            return dp[pos][tight][started];
        }

        int limit = 9;
        
        if(tight == 1){
            limit = digits[pos];
        }

        long ans = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int isTight = 0;
            
            if(tight == 1 && digit == limit){
                isTight = 1;
            }
            
            int nstart = 0;
            
            if(started == 1 || (digit != 0)){
                nstart = 1;
            }
            
            if(digit == d && nstart == 1){
                continue;
            }
            
            ans+= solve(pos+1, isTight, nstart);
            
        }

        return dp[pos][tight][started] = ans;
    }
}


/*
Numbers Without d — Intuition

Don't check every number from 1 → n. Build numbers digit-by-digit and count only valid numbers.

At every digit:

Try possible digits 0–9.
If the digit is d, reject it.
tight ensures we never create a number > n.
started handles leading zeros.
When all digits are chosen, we found one valid number.
Remember

Digit DP = Build numbers digit-by-digit under n, while rejecting invalid digits.

n → digits
     ↓
choose digit
     ↓
valid? → yes
     ↓
still <= n?
     ↓
next digit

That's the whole intuition.
*/