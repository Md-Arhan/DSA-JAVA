import java.util.Arrays;

public class MaximizeMinimumPowerCity {
    class Solution {
    public long maxPower(int[] stations, int r, int k) {

        long low = 0;
        long high = Arrays.stream(stations).asLongStream().sum() + k;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, k, stations, r)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean isPossible(long mid, long k, int[] st, int r) {
        long sum = 0;
        int n = st.length;

        long[] s = new long[n];
        for (int i = 0; i < n; i++)
            s[i] = st[i];

        for (int i = 0; i < r; i++) {
            sum += s[i];
        }
        for (int i = 0; i < n; i++) {
            if ((i + r) < n) {
                sum += s[i + r];
            }
            if ((i - (r + 1)) >= 0) {
                sum -= s[i - (r + 1)];
            }
            if (sum < mid) {
                if (mid - sum > k) {
                    return false;
                }
                int addPos = Math.min(n - 1, i + r);
                s[addPos] += (mid - sum);
                k -= (mid - sum);
                sum = mid;

            }
        }
        return true;
    }
}
}



/*
 * 💡 Approach Summary

Binary Search on Answer (mid)
We guess a target power mid.
Then we check (using isPossible) if we can make every city’s total power ≥ mid using ≤ k new stations.

Sliding Window for Power Calculation
We maintain a running sum = total power covering the current city.
As we move from left to right, we add the new rightmost element and remove the one going out of range.

When sum < mid
It means the current city doesn’t have enough power.
We add new stations at i + r (rightmost point still within range).
This helps current and future cities because the new station’s range extends forward.
Decrease k accordingly.

If we ever need more than k new stations → not possible.
Otherwise, it’s possible for that mid.

Binary search continues to find the highest mid that’s possible.
 */