package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kth_Largest_Odd_Number {

    public static int findKthLargest(int L, int R, int K){
        int start = (L % 2 == 0) ? L + 1 : L;
        int end = (R % 2 == 0) ? R - 1 : R;

        // If no odd numbers exist in the range, return 0
        if (start > end) return 0;

        // Calculate the total number of odd numbers in the range
        int count = (end - start) / 2 + 1;

        // If K is greater than the total count, return 0what is 
        if (K > count) return 0;

        // Calculate the Kth largest odd number
        return end - 2 * (K - 1);
    }

    public static int kthLargestOdd(int L, int R, int K) {
        List<Integer> oddNumbers = new ArrayList<>();

        // Step 1: Loop through the range and collect odd numbers
        for (int i = L; i <= R; i++) {
            if (i % 2 != 0) {
                oddNumbers.add(i);
            }
        }

        // Step 2: Sort the list in descending order
        Collections.sort(oddNumbers, Collections.reverseOrder());

        // Step 3: Check if K is within the range of available odds
        if (K > oddNumbers.size()) {
            return 0;
        }

        // Step 4: Return the K-th largest odd number (0-based index)
        return oddNumbers.get(K - 1);
    }

    public static void main(String[] args) {
       System.out.println(findKthLargest(3, 15, 3));
       int number = kthLargestOdd(-3, 3, 1);
       System.out.println(number);
    }
}




/*
 * Dry Run Example 1:
1. int start = (L % 2 == 0) ? L + 1 : L;
Meaning:

If L is even (L % 2 == 0), it moves to the next odd number by adding 1.

If L is already odd, keep it as it is.

Why?
Because we are only interested in odd numbers. We adjust L to make sure start points to the first odd number ≥ L.

2. int end = (R % 2 == 0) ? R - 1 : R;
Meaning:

If R is even, move back by 1 to reach the last odd number ≤ R.

If R is already odd, keep it.

Why?
Same reason — we need to focus only on odd numbers. So adjust end to the last odd number ≤ R.

3. if (start > end) return 0;
Meaning:

After adjusting, if start has crossed end, that means no odd numbers exist in [L, R].

Why?
Imagine L = 6 and R = 6.

L is even, so start = 7.

R is even, so end = 5.

start > end → no odds exist between 6 and 6 → return 0.

4. int count = (end - start) / 2 + 1;
Meaning:

Count the total number of odd numbers between start and end.

Odd numbers are spaced 2 apart (like 1, 3, 5, 7, 9...).

Why formula?

(end - start) / 2 gives how many jumps of 2 you can make.

+1 is because both start and end are inclusive.

👉 Example:
start = 1, end = 9 → (9 - 1) / 2 + 1 = 4 + 1 = 5 odds (1, 3, 5, 7, 9).

5. if (K > count) return 0;
Meaning:

If K is larger than the total number of odd numbers, then it's impossible to find the K-th largest odd number.

Why?
Simple — you can't find the 6th largest odd number if only 3 odd numbers exist.

6. return end - 2 * (K - 1);
Meaning:

Start from the largest odd (end).

Each previous odd number is 2 less.

So move back by 2 * (K - 1) to reach the K-th largest.

Why?
Each odd number is separated by 2.

1st largest → end

2nd largest → end - 2

3rd largest → end - 4

...

Thus, formula: end - 2 * (K - 1)


(end - start) / 2 → counts the gaps between odd numbers.

+1 → includes the starting odd number itself.
 */