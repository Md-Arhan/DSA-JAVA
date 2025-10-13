package DP.LongestIncreasingSubsequnce;

import java.util.Arrays;

public class MountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);
        for (int i = n-1; i >=0; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
                maxMountain = Math.max(maxMountain, LIS[i] + LDS[i] - 1);
            }
        }

        return n - maxMountain;
    }
}


/*
 * I calculated the LIS and LDS for every index to find all possible peaks.
 * For each valid peak (where both LIS and LDS > 1), I calculated the length of the mountain centered at that peak.
 * The longest such mountain tells me how many elements I can keep, so I subtract that from the total
 * to get the minimum number of removals.
 */