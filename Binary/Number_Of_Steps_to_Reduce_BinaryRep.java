class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';

            if (bit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
}


/*
What Actually Happens in the Real Problem

If a number is:

✅ Even (last bit = 0)

→ divide by 2
→ this is just a right shift
→ costs 1 step

✅ Odd (last bit = 1)

→ add 1
→ then divide by 2
→ costs 2 steps

🔎 Now Let’s Understand the Code
for (int i = s.length() - 1; i > 0; i--)

We stop at i > 0 because:

We don’t process the most significant bit separately.

We handle it at the end using return steps + carry.

🧩 Key Line
int bit = s.charAt(i) - '0';

Gets current binary digit.

🔥 The Important Condition
if (bit + carry == 1)

This means:

If current bit is 1 and no carry

OR bit is 0 and carry is 1

Then the number is effectively odd.

So:

We need +1 operation (add 1)

Then +1 operation (divide by 2)

Total = 2 steps

And now we generate a carry

steps += 2;
carry = 1;
🟢 Else Case
else {
    steps += 1;
}

This means:

Either bit+carry = 0 (even)

Or bit+carry = 2 (even after carry)

So just divide by 2 → 1 step.

💡 Why Do We Return steps + carry?

After finishing loop:

If there’s still a carry left,
that means the most significant bit became 10

Example:

111 + 1 → 1000

So we need one extra step. */