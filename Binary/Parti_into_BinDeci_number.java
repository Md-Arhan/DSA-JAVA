public class Parti_into_BinDeci_number {
    class Solution {
        public int minPartitions(String n) {
            int len = n.length();

            int max = 0;

            for (int i = 0; i < len; i++) {
                max = Math.max(n.charAt(i) - '0', max);
            }

            return max;
        }
    }
}


/*
Core Intuition

Each deci-binary number can contribute:

At most 1 at any digit position.

So think of it like this:

For every digit position,
you are stacking 1’s vertically.

📌 Example: n = "32"

Digits:

3   2

At first position → digit is 3
That means:

You need at least 3 numbers,
because each number can contribute only 1 there.

So answer ≥ 3

And actually, 3 is enough. */