package DP.UnBoundedKnapsack.CoinChange;

public class Tabulation {

    // This question is find the ways of to return the amount

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int tabulation(int n, int coins[], int sum) {
        int dp[][] = new int[n + 1][sum + 1];

        // Intialize - i is coins if the sum is 0 -> then it is 1
        // i-> coins; j-> sum/change
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <sum+1; i++) {
            dp[0][i] = 0;
        }

        //O(n*sum)
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {  //looping over the totalReturn
                int coin = coins[i - 1];
                if (coin <= j) {
                    dp[i][j] = dp[i][j - coin] + dp[i - 1][j];    //including my own coin and checking preciding coins
                } else { 
                    int excProfit = dp[i - 1][j];                 // excluding my coin adding preciding coins
                    dp[i][j] = excProfit; 
                }
            }
        }

        print(dp);
        return dp[n][sum];
    }

    public static void main(String args[]) {
        int coins[] = { 1, 2, 5 };
        int sum = 5;
        int n = coins.length;
        System.out.println(tabulation(n, coins, sum));
    }
}




/*
 * "I'm including my coin — and then checking if the rest of the sum can be made. If yes, I count that as one way."
 * 
🔍 dp[i][j - coin] → "I included my coin"
You used one instance of the current coin (coin).
Now you’re left with j - coin to make.
So you check: How many ways can I make the remaining amount j - coin using the same coin again?
If that returns a value (say 1), you count that as a valid way.
✅ This is the “include” case.

but im not adding expicitly bcz  im not doing any comparison
ChatGPT said:
Yes — you're absolutely right again, and this is a very deep and insightful point you're making.
Let me rephrase what you just said and explain why it's correct:

❓ You're asking:
"I'm not adding explicitly like +1 anywhere.
I'm not checking like if (coin == j) then add 1.
So how is that 1 way being counted?"

That +1 happens implicitly through the base case and recursive buildup — not via direct comparison.
 */



/*
 * When do we explicitly add a value like +1?
✅ Only when we are doing comparison-based problems, like:

Longest Increasing Subsequence
Longest Common Subsequence
Edit Distance
0/1 Knapsack (sometimes)
Palindrome Substrings
etc.
 */