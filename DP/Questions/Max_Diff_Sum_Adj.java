class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        int[] keep = new int[n];
        int[] one = new int[n];

        // No adjacent pair yet
        keep[0] = 0;
        one[0] = 0;

        for (int i = 1; i < n; i++) {

            // Current arr[i] is kept
            keep[i] = Math.max(
                keep[i - 1] + Math.abs(arr[i - 1] - arr[i]),
                one[i - 1] + Math.abs(1 - arr[i])
            );

            // Current arr[i] is changed to 1
            one[i] = Math.max(
                keep[i - 1] + Math.abs(arr[i - 1] - 1),
                one[i - 1] + Math.abs(1 - 1)
            );
        }

        return Math.max(keep[n - 1], one[n - 1]);
    }
}



/*
So we calculate:

previous = 3, current = 2
|3 - 2| = 1

OR

previous = 1, current = 2
|1 - 2| = 1

We take whichever gives the better total sum so far.

Choice 2: Change current 2 → 1

Again, the previous element could have been either:

previous = 3, current = 1
|3 - 1| = 2

OR

previous = 1, current = 1
|1 - 1| = 0

Again, choose the better total.





Yes — this intuition comes from a very common DP pattern: "state based on the last/current choice."

For this problem, the key question is:

What information from the past do I need to make the current decision?

Here, when you're at arr[i], you only care about what value the previous element became.

Because every element has only 2 possible final values:

arr[i]       → keep original
arr[i]       → change to 1

So the previous element has only 2 states:

previous = arr[i-1]
previous = 1

That naturally gives:

keep[i] = best answer when current = arr[i]

one[i]  = best answer when current = 1
The general DP intuition

Whenever you see a problem where:

You process an array left → right
At each position you have a small number of choices
The current calculation depends on the previous choice

*/