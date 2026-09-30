import java.util.Arrays;

public class PartitionGivenDifference {
    class Solution {

        public int solve(int[] arr, int i, int target, int sum, int dp[][]) {
            int n = arr.length;

            // Base case: reached end
            if (i == n) {
                return (sum == target) ? 1 : 0;
            }

            if (sum > target) {
                return 0;
            }

            if (dp[i][sum] != -1) {
                return dp[i][sum];
            }

            // Choice 1: include arr[i]
            int include = solve(arr, i + 1, target, sum + arr[i], dp);

            // Choice 2: exclude arr[i]
            int exclude = solve(arr, i + 1, target, sum, dp);

            return dp[i][sum] = include + exclude;
        }

        public int countPartitions(int[] arr, int diff) {
            int n = arr.length;
            int totalSum = 0;
            for (int num : arr)
                totalSum += num;
            int dp[][] = new int[n + 1][totalSum + 1];

            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // If invalid (odd or diff too large), no solutions
            if ((totalSum + diff) % 2 != 0 || diff > totalSum)
                return 0;

            int target = (totalSum + diff) / 2;

            return solve(arr, 0, target, 0, dp);
        }
    }
}




/*



Step 3: What do we want?

We want:

S1 - S2 = diff

Replace S2:

S1 - (total - S1) = diff
🤯 Now simplify (don’t panic)
S1 - total + S1 = diff
2*S1 = total + diff
💡 Final idea
S1 = (total + diff) / 2
🚀 What does this mean in simple words?

👉 You just need to:

Count subsets whose sum = (total + diff)/2






❓ Your idea

You’re asking:

if (sum == target) {
    return 1;
}

👉 Why can’t we stop here?

🚨 Short Answer

Because:

👉 You might miss other valid subsets later

We must explore all possibilities, not stop early.
*/