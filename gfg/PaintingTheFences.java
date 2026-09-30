public class PaintingTheFences {
    class Solution {

        int countWays(int n, int k) {
            if (n == 1)
                return k;

            int prev2 = k; // dp[1]
            int prev1 = k * k; // dp[2]

            for (int i = 3; i <= n; i++) {
                int curr = (k - 1) * (prev1 + prev2);
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    };
}


/*
   What this code is doing

Instead of mixing everything in one formula, this code separates the logic cleanly into:

same → last two fences have SAME color
diff → last two fences have DIFFERENT color
🎯 Step 1: Base case (n = 2)
int same = k;
int diff = k * (k - 1);
🔹 Why?

For 2 fences:

SAME:
AA, BB, CC ...
→ k ways
DIFFERENT:
AB, AC, BA, BC ...
→ k * (k - 1)
🔁 Step 2: Transition (for i ≥ 3)
int newSame = diff;
int newDiff = (same + diff) * (k - 1);

Let’s break this VERY clearly.

🟢 newSame = diff

To make last two SAME:

(i-1) == (i)

👉 Previous must be DIFFERENT:

... X Y → ... X Y Y

If previous was SAME:

... Y Y → ... Y Y Y ❌ (invalid)

So:

newSame = diff
🔵 newDiff = (same + diff) * (k - 1)

We want:

(i-1) ≠ (i)

👉 Take ANY valid sequence:

same + diff = total ways till i-1

Now:

choose color ≠ previous → (k - 1)

So:

newDiff = (same + diff) * (k - 1)
🔄 Update
same = newSame;
diff = newDiff;


We are computing:

newDiff → number of ways where last two fences are DIFFERENT at index i

That means:

color[i] ≠ color[i-1]
🧠 Step 1: Where do these sequences come from?

We look at all valid sequences till (i-1):

same + diff

👉 Why?

Because:

same = sequences ending with same
diff = sequences ending with different

👉 Together:

same + diff = total valid sequences till i-1

Move forward (like sliding window)















Assume:

(i-1) = B
k = 3 → A, B, C

Total choices:

A, B, C   (3 choices)
🟢 SAME group

We want:

color[i] == color[i-1]

👉 Only:

B

So:

SAME = 1 choice
🔵 DIFFERENT group

We want:

color[i] ≠ B

👉 Remove B:

A, C

So:

DIFFERENT = k - 1 = 2 choices
🔥 Important Observation
Total = SAME + DIFFERENT
      = 1 + (k - 1)
      = k

👉 We didn’t lose anything
👉 We just split cleanly



One-line clarity

👉 “From k colors, exactly 1 matches previous (same), and the remaining k-1 are different — DP just counts how many sequences use each.”    

*/