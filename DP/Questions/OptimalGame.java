public class OptimalGame {
    class Solution {
        public int maxAmt(int i, int j, int arr[], int dp[][]) {
            if (i > j) {
                return 0;
            }

            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int leftPick = arr[i] + Math.min(
                    maxAmt(i + 2, j, arr, dp),
                    maxAmt(i + 1, j - 1, arr, dp));

            int rightPick = arr[j] + Math.min(
                    maxAmt(i, j - 2, arr, dp),
                    maxAmt(i + 1, j - 1, arr, dp));

            return dp[i][j] = Math.max(leftPick, rightPick);
        }

        public int maximumAmount(int arr[]) {
            // code here
            int n = arr.length;

            int dp[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            return maxAmt(0, n - 1, arr, dp);
        }
    }

}


/*
🎯 Imagine this game

There are coins on a table in a line.

You and an opponent take turns.

Each turn you must take only from left or right.

Both of you are smart and want to win.

Your goal = get as many coins as possible.
Opponent’s goal = stop you from getting many coins.

Now think: What happens after YOUR move?

You pick one coin…

Then the opponent chooses a coin next.

Will they help you get more coins later?
👉 NO — they will block you.

So after your move, your future result depends on the worst future choice opponent forces on you.

✳️ That’s why we use min(...)

Let’s say you pick the left coin.

Two possible situations after that:

Opponent takes coin from the new left

Opponent takes coin from the right

You don’t know which they will take.
But they will pick the one that hurts you most.

So you must assume the minimum future value:

pickLeft = arr[l] + Math.min( future1 , future2 )


You are calculating:

“If I pick left, what is the worst thing the opponent can do to me next?” */