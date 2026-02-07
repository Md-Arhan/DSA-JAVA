package BinarySearch;

public class MaxRunningComputer {
    class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long total = 0;
        for (int b : batteries) total += b;

        long left = 1, right = total / n, ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRun(mid, batteries, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canRun(long time, int[] batteries, int n) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
        }
        return total >= (long) time * n;
    }
}

}
