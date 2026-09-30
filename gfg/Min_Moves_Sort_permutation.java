public class Min_Moves_Sort_permutation {
    class Solution {
	public int minMoves(int[] arr) {
		// code here
		int n = arr.length;
		int dp[] = new int[n + 1];
		int max = 0;
		
		for (int num : arr) {
			dp[num] = dp[num-1] + dp[num] + 1;
			max = Math.max(max, dp[num]);
		}
		
		return n - max;
	}
}

}



/*
Minimum Moves to Sort — DP

Problem: Move any element only to the beginning or end. Find minimum moves to sort.

Key Idea
Elements that we don't move must already be in the correct relative order.
They must form a consecutive sequence of values:
x, x+1, x+2, ...
Find the longest consecutive subsequence.
Move all remaining elements.
Answer = n - longest consecutive subsequence length
DP
dp[x] = length of longest consecutive subsequence ending at x

For every num in arr:

dp[num] = dp[num - 1] + 1;
max = Math.max(max, dp[num]);

Why?

If num-1 appeared earlier:
    sequence ending at num-1 can be extended by num.

Example:
2 → 3 → 4

dp[2] = 1
dp[3] = dp[2] + 1 = 2
dp[4] = dp[3] + 1 = 3
Example
arr = [2, 1, 3]

2 → dp[2] = 1
1 → dp[1] = 1
3 → dp[3] = dp[2] + 1 = 2

Longest chain = 2 → 3, length 2.

Answer = 3 - 2 = 1
*/