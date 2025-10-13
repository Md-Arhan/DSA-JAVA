package DP.Questions;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfJobSeq {
    
    static class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        // Step 1: Store jobs and sort by endTime
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // Step 2: DP array (initialize with -1 to indicate uncomputed values)
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Step 3: Start recursion from index 0
        return findMaxProfit(jobs, 0, dp);
    }

    private static int findMaxProfit(Job[] jobs, int index, int[] dp) {
        if (index >= jobs.length) return 0;  // Base case: No jobs left
        if (dp[index] != -1) return dp[index]; // Return stored result if already computed

        // Case 1: Skip the current job
        int maxProfit = findMaxProfit(jobs, index + 1, dp);

        // Case 2: Include the current job
        int nextIndex = binarySearch(jobs, index);
        int includeProfit = jobs[index].profit + (nextIndex == -1 ? 0 : findMaxProfit(jobs, nextIndex, dp));

        // Take the maximum of both cases
        maxProfit = Math.max(maxProfit, includeProfit);

        // Store result in dp array and return
        dp[index] = maxProfit;
        return maxProfit;
    }

    // Binary search to find the latest job that doesn't overlap
    private static int binarySearch(Job[] jobs, int index) {
        int left = index + 1, right = jobs.length - 1, target = jobs[index].end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].start >= target) {
                if (mid == 0 || jobs[mid - 1].start < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // No valid job found
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        System.out.println("Maximum Profit: " + jobScheduling(startTime, endTime, profit));
    }
}
