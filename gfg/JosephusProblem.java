public class JosephusProblem {
    class Solution {

        public int solve(int n, int k) {
            if (n == 1)
                return 0;

            return (solve(n - 1, k) + k) % n;
        }

        public int josephus(int n, int k) {
            // code here
            return solve(n, k) + 1;
        }
    }
}


/*
Instead of simulating the whole circle, we think in reverse:

Suppose you already know the winner when there are n-1 people.

Now imagine adding one more person to make it n.

When the first elimination happens in the n-sized circle, the circle “rotates” by k positions.

So the winner from the smaller circle must be shifted forward by k to match its new position in the bigger circle.
 */

// Formula : (josephus(n - 1, k) + k) % n