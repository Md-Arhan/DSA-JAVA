package Arrays;

import java.util.HashMap;

public class SubArraySumK {
    public int cntSubarrays(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink the window while sum > k
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

    }

}

/*
 * for non-negative and positive there will be hashmap if only for postive also
 * two pointer will wprk
 */