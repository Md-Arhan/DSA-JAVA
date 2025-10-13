package Arrays;

import java.util.Arrays;

public class PrefixSuffixSum {
     public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        // Step 1: Compute Prefix Array
        prefix[0] = 1; // First element has no prefix
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Compute Suffix Array
        suffix[n - 1] = 1; // Last element has no suffix
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Step 3: Compute Final Answer Using Prefix and Suffix Arrays
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        // Print prefix and suffix arrays for clarity
        System.out.println("Prefix: " + Arrays.toString(prefix));
        System.out.println("Suffix: " + Arrays.toString(suffix));

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("\nInput: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}
