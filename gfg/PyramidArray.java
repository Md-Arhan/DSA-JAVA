public class PyramidArray {
    class Solution {
        public int formPyramid(int[] arr) {
            // code here
            int n = arr.length;
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += arr[i];

            // A pyramid of height 1 (a single stone of height 1) is always possible
            if (n <= 2)
                return sum - 1;

            int[] left = new int[n];
            int[] right = new int[n];

            // left [i]= max possible pyramid height ending at i, built from the left
            left[0] = Math.min(1, arr[0]);
            for (int i = 1; i < n; i++)
                left[i] = Math.min(left[i - 1] + 1, arr[i]);

            // right [i]= max possible pyramid height ending at i, built from the right
            right[n - 1] = Math.min(1, arr[n - 1]);
            for (int i = n - 2; i >= 0; i--)
                right[i] = Math.min(right[i + 1] + 1, arr[i]);

            long maxSq = 0;
            for (int i = 0; i < n; i++) {
                int h = Math.min(left[i], right[i]); // achieveable peak height at 1
                maxSq = Math.max(maxSq, (long) h * h); // pyramid of heighr h has area h^2
            }

            return (int) (sum - maxSq);
        }
    }
}

//The current height can be at most previous height + 1 when moving toward the peak, or it can be smaller if fewer stones are available.

/*
========================================
FORM PYRAMID – DSA NOTES (JAVA)
========================================

PROBLEM:
Given an array where each element represents the number of stones at a position, find the minimum number of stones to remove to form the largest valid pyramid.

----------------------------------------
1. CORE IDEA
----------------------------------------

Use two arrays:

left[i]  = Maximum achievable height at index i
           when building from left to right.

right[i] = Maximum achievable height at index i
           when building from right to left.

The maximum achievable pyramid height at index i is:

h = min(left[i], right[i])

----------------------------------------
2. LEFT ARRAY (LEFT TO RIGHT)
----------------------------------------

Initialize:

left[0] = min(1, arr[0])

Formula:

left[i] = min(left[i-1] + 1, arr[i])

INTUITION:
- Height can increase by at most 1 from the previous position.
- Height cannot exceed the available stones at the current position.
- Take the minimum of these two values.

----------------------------------------
3. RIGHT ARRAY (RIGHT TO LEFT)
----------------------------------------

Initialize:

right[n-1] = min(1, arr[n-1])

Formula:

right[i] = min(right[i+1] + 1, arr[i])

INTUITION:
- Start from the rightmost position.
- Move toward the left.
- Height can increase by at most 1 from the next position.
- Height cannot exceed the available stones.

----------------------------------------
4. FIND MAXIMUM PYRAMID HEIGHT
----------------------------------------

At every index:

h = min(left[i], right[i])

This ensures the pyramid satisfies the height restrictions on both sides.

If the problem defines pyramid area as h * h:

maxSq = max(maxSq, h * h)

----------------------------------------
5. CALCULATE MINIMUM REMOVALS
----------------------------------------

sum = Total number of stones.

Answer:

sum - maxSq

NOTE:
The area formula depends on the problem definition.
If the pyramid consists of rows containing 1, 2, 3, ..., h stones,
its total number of stones is h * (h + 1) / 2.

----------------------------------------
6. EXAMPLE
----------------------------------------

Input:

arr = [1, 2, 3, 4, 2, 1]

LEFT ARRAY:

left = [1, 2, 3, 4, 2, 1]

RIGHT ARRAY:

right = [1, 2, 3, 3, 2, 1]

Calculate h = min(left[i], right[i]):

h = [1, 2, 3, 3, 2, 1]

Maximum achievable height = 3

Using h * h:

maxSq = 3 * 3 = 9

Total stones:

sum = 1 + 2 + 3 + 4 + 2 + 1 = 13

Answer:

13 - 9 = 4

----------------------------------------
8. COMPLEXITY
----------------------------------------

Time Complexity:  O(n)
Space Complexity: O(n)

----------------------------------------
9. MEMORY TRICK
----------------------------------------

LEFT  → Previous index + 1
RIGHT → Next index + 1
BOTH  → Take minimum
FINAL → Total stones - Maximum pyramid area

======================================== */