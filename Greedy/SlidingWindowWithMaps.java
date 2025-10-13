package Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindowWithMaps {
    public static int countCompleteSubarrays(int[] nums) {
        // Step 1: Get number of distinct elements in entire array
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int totalDistinct = set.size();

        // Step 2: Sliding window logic
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand window by adding current number
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window while it contains all distinct elements
            while (freqMap.size() == totalDistinct) {
                // All subarrays from [left, right], [left+1, right], ..., [right, right] are valid
                count += nums.length - right;

                // Shrink window from the left
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println("Complete Subarrays: " + countCompleteSubarrays(nums)); // Output: 4
    }

}


/*
 * The key idea:
If the window [left..right] is a complete subarray, then any longer subarray starting at left and ending at right+1, right+2, ..., up to the end of array will also be complete.

Because adding more elements cannot remove distinct elements — it can only keep or increase duplicates.
 */

 /*
  * | right                  | Window (left to right) | freqMap         | freqMap.size | count added | Total count |
| ---------------------- | ---------------------- | --------------- | ------------ | ----------- | ----------- |
| 0                      | \[1]                   | {1=1}           | 1            | 0           | 0           |
| 1                      | \[1,3]                 | {1=1, 3=1}      | 2            | 0           | 0           |
| 2                      | \[1,3,1]               | {1=2, 3=1}      | 2            | 0           | 0           |
| 3                      | \[1,3,1,2]             | {1=2, 3=1, 2=1} | 3 ✅          | 2           | 2           |
| shrink left → \[3,1,2] | {1=1, 3=1, 2=1}        | 3 ✅             | 2            | 4           |             |
| shrink left → \[1,2]   | {1=1, 2=1}             | 2               | stop shrink  |             |             |
| 4                      | \[1,2,2]               | {1=1, 2=2}      | 2            | 0           | 4           |

  */