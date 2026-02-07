import java.util.Arrays;

public class MaximumFreqOFEleAfterPerformingOperations {
    class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int max = 0;
        Arrays.sort(nums);

        int freq[] = new int[nums[n - 1] + k + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i <= nums[n - 1] + k; i++) {
            freq[i] += freq[i - 1];
        }

        for (int target = 0; target <= nums[n-1]; target++) {
            if(freq[target] == 0) continue;

            int left = Math.max(0, target - k); 
            int right = target + k;

            int totalCount = freq[Math.min(right, freq.length - 1)]
                    - (left > 0 ? freq[left - 1] : 0);

            int targetCount = freq[target] - (target > 0 ? freq[target - 1] : 0);

            int needConversion = totalCount - targetCount;

            int canConvert = targetCount + Math.min(needConversion, numOperations);

            max = Math.max(canConvert, max);
        }

        return max;
    }
}
}
