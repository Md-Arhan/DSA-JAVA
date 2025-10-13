package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class maxSubArrayWithinRange {
    int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = a; i <= n; i++) {
            // Remove indices that are too far left (length > b)
            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }

            // Only add index to deque when subarray of length >= a is possible
                int j = i - a;
                System.out.println(j);
                while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[j]) {
                    dq.pollLast();
                }
                dq.addLast(j);

            // Update max sum if deque is not empty (i.e., valid subarray exists)
            if (!dq.isEmpty()) {
                max = Math.max(max, prefix[i] - prefix[dq.peekFirst()]);
            }
        }

        return max;
}



/*
 * Step 3: Explanation per step

i = 2

j = i - a = 0 → add 0 to deque → dq = [0]

max = prefix[2] - prefix[0] = 9 - 0 = 9

i = 3

j = 3 - 2 = 1 → add 1 to deque (prefix[1]=4 ≥ nothing removed from back) → dq = [0,1]

max = prefix[3] - prefix[dq.front] = 8 - 0 = 8 → max stays 9

i = 4

j = 4 - 2 = 2 → add 2 to deque (prefix[2]=9 ≥ nothing removed from back) → dq = [0,1,2]

max = prefix[4] - prefix[dq.front] = 6 - 0 = 6 → max stays 9

i = 5

Remove indices < i - b = 5 - 4 = 1 → remove 0 → dq = [1,2]

j = 5 - 2 = 3 → add 3 to deque, remove back indices with prefix ≥ prefix[3]=8 → remove 2 (prefix[2]=9) → dq = [1,3]

max = prefix[5] - prefix[dq.front] = 12 - 4 = 8 → max stays 9
 */


/*
 * 1️⃣ What we want from the deque

The deque stores possible starting indices of subarrays.

When we look at an ending index i, the best subarray sum is
prefix[i] - prefix[start] where start is a valid index in the window.

To maximize that difference, we want the smallest prefix[start] inside the window
(because subtracting a smaller number → bigger result).

So the deque should always be monotonically increasing in prefix values:
front = smallest prefix, back = largest.
 */



 

/*
 * 2️⃣ Your prefix sequence

Suppose the prefix array values (at some point) we’re considering are

index : 1  2  3  4  5  6
value : 4, 9, 8, 6, 12,10


When we come to index 3 (value 8):

Back of deque has index 2 (value 9).

Compare prefix[3] = 8 with prefix[2] = 9.

8 < 9 → remove 2.

Now deque keeps [1 (4), 3 (8)].

3️⃣ Why is it safe to remove 9?

Think of any future end index i (≥ 3):

Using j=2 → sum = prefix[i] - 9

Using j=3 → sum = prefix[i] - 8

Because 8 < 9,
prefix[i] - 8 is always ≥ prefix[i] - 9.

So for every possible future i, starting at index 3 gives a sum at least as large as starting at 2.
The index with prefix 9 will never again be the best starting point.

This is true even if you worry about length:

If subarray length must be between a and b,
any i that allows j=2 (start at 2) also allows j=3 (start at 3),
because 3 is later, giving a shorter subarray, which still fits the length upper bound b.

Hence index 2 is dominated by index 3.
 */