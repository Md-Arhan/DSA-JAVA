class Solution {

    public int optimalKeys(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Press A
            dp[i] = dp[i - 1] + 1;

            // Try copy-paste sequences
            for (int j = 3; j < i; j++) {

                dp[i] = Math.max(
                    dp[i],
                    dp[i - j] * (j - 1)
                );
            }
        }

        return dp[n];
    }
} 

/*
/*
But remember:

Before pasting, the original text is already present on screen.

So total copies become:

original + pasted copies

which is:

1 + (j - 2)

Simplify:

j - 1

That’s why:

dp[i-j] * (j-1)




Example

Suppose:

dp[i-j] = 3

and:

j = 4

Operations:

Ctrl+A
Ctrl+C
Ctrl+V
Ctrl+V

Pastes:

4 - 2 = 2

Total groups:

1 original + 2 pasted
= 3 groups

Final:

3 * 3 = 9*/ 