package DP.Questions;

import java.util.Arrays;

public class BurstBallon {
    /*
     * Case: Choosing i = 2 (nums[2] = 1 is burst last)
       left = 1, right = 4, i = 2
       coins = nums[left - 1] * nums[i] * nums[right + 1]
       Substituting values:
       java
       Copy
       Edit
       coins = nums[0] * nums[2] * nums[5] = 1 * 1 * 1 = 1
       Why?
       nums[0] = 1 → Virtual balloon before [3, 1, 5, 8]
       nums[2] = 1 → The balloon we are bursting
       nums[5] = 1 → Virtual balloon after [3, 1, 5, 8]
       Coins earned by bursting 1 last = 1
     */


     /*
      * 
      The newNums array has extra virtual balloons at both ends (newNums[0] and newNums[n+1]).
The actual elements from the original nums are placed in newNums[1] to newNums[n].
The recursive burst() function works only within the original range (1 to n), without touching the virtual balloons directly
      */

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Create a new array with virtual balloons (1) at both ends
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        // Memoization table
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return burst(dp, newNums, 1, n);
    }

    private static int burst(int[][] dp, int[] nums, int left, int right) {
        if (left > right) return 0; // No balloons to burst

        if (dp[left][right] != -1) return dp[left][right]; // Return cached result

        int maxCoins = 0;

        // Try bursting each balloon in the range [left, right] last
        for (int i = left; i <= right; i++) {
            int coins = nums[left - 1] * nums[i] * nums[right + 1] // Coins from bursting i
                      + burst(dp, nums, left, i - 1)  // Left subproblem
                      + burst(dp, nums, i + 1, right); // Right subproblem
            maxCoins = Math.max(maxCoins, coins);
        }

        return dp[left][right] = maxCoins; // Store the result
    }

    public static void main(String args[]){

    }
}


/*
 * Correct Intuition: Burst Last Balloon in a Range
💡 We assume that the current balloon we pick (say k) is the last one to burst in the range [left, right].

That way:
The neighbors left - 1 and right + 1 are still unburst.
So we can safely multiply: nums[left - 1] * nums[k] * nums[right + 1]
Then we recursively burst everything to the left and right of k.
🧠 Why "burst last" is better than "burst first"?
Because bursting the first balloon makes the neighbors unknown:
You can't tell which balloons will be adjacent after that.
But when k is the last, you guarantee that:
Left: nums[left - 1] is unburst (it wasn't in the range)
Right: nums[right + 1] is unburst (outside range)
So nums[k] is "sandwiched" between known neighbors, making it safe to compute.
 */