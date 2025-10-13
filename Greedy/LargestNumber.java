package Greedy;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Step 1: Convert numbers to Strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Step 2: Custom comparator to sort strings
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        /*
         * This is a lambda expression in Java that defines a custom comparator for
         * sorting.
         * 
         * (a, b) — parameters representing two elements being compared (here, String
         * values).
         * 
         * -> — separates the parameter list from the body of the lambda.
         * 
         * (b + a).compareTo(a + b) — logic for comparing a and b.
         */

        /*
         * Arrays.sort(strNums, new Comparator<String>() {
         * public int compare(String a, String b) {
         * return (b + a).compareTo(a + b);
         * }
         * });
         */

        // Step 3: Handle edge case: when the largest number is 0
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Step 4: Concatenate all numbers to form the largest number
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }
}
