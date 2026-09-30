public class Max_Abs_Diff_Two_Subarrays {
    class Solution {
        public int maxDiffSubArrays(int[] arr) {
            // code here
            int n = arr.length;

            if (n < 2)
                return 0;

            // Space Optimization: Only precompute right (suffix) values

            int[] maxRight = new int[n];

            int[] minRight = new int[n];

            // 1. Precompute right values (Suffix)

            int currentMax = arr[n - 1], maxSoFar = arr[n - 1];

            int currentMin = arr[n - 1], minSoFar = arr[n - 1];

            maxRight[n - 1] = maxSoFar;

            minRight[n - 1] = minSoFar;

            for (int i = n - 2; i >= 0; i--) {

                currentMax = Math.max(arr[i], currentMax + arr[i]);

                maxSoFar = Math.max(maxSoFar, currentMax);

                maxRight[i] = maxSoFar;

                currentMin = Math.min(arr[i], currentMin + arr[i]);

                minSoFar = Math.min(minSoFar, currentMin);

                minRight[i] = minSoFar;

            }

            // 2. Compute left values on the fly and find the max difference

            int maxDiff = Integer.MIN_VALUE;

            int currentMaxLeft = arr[0], maxLeftSoFar = arr[0];

            int currentMinLeft = arr[0], minLeftSoFar = arr[0];

            for (int i = 0; i < n - 1; i++) {

                // Update left values up to index i

                if (i > 0) {

                    currentMaxLeft = Math.max(arr[i], currentMaxLeft + arr[i]);

                    maxLeftSoFar = Math.max(maxLeftSoFar, currentMaxLeft);

                    currentMinLeft = Math.min(arr[i], currentMinLeft + arr[i]);

                    minLeftSoFar = Math.min(minLeftSoFar, currentMinLeft);

                }

                // Calculate differences with the precomputed right values at i + 1

                int diff1 = Math.abs(maxLeftSoFar - minRight[i + 1]);

                int diff2 = Math.abs(minLeftSoFar - maxRight[i + 1]);

                maxDiff = Math.max(maxDiff, Math.max(diff1, diff2));

            }

            return maxDiff;
        }
    }
}



/*
The important thing to notice is that the two subarrays must be contiguous and non-overlapping, and we want to maximize

∣sum(A)−sum(B)∣

The absolute value means there are only two possibilities:

Large positive sum − Large negative sum
Large negative sum − Large positive sum

So we need to find a maximum-sum subarray on one side and a minimum-sum subarray on the other side.



The key insight is that once you decide a split point, the two subarrays are independent: one must lie entirely on the left and the other entirely on the right. By precomputing the best (maximum and minimum) subarray sums on each side of every possible split, you can evaluate every split in constant time.

*/