public class Min_Increment_Or_Double_Convert {
    class Solution {
        int countMinOperations(int[] arr) {
            int add = 0, multi = 0;
            for (int i : arr) {
                int[] result = getAddDouble(i);
                add += result[0];
                multi = Math.max(multi, result[1]);  // In the backward process, once an element reaches 0, it is "done." Any additional global divide operations leave it at 0, so we only keep dividing for the elements that still need it. That's why the total number of divide operations is the maximum, not the sum.
            }
            return add + multi;
        }

        private int[] getAddDouble(int num) {
            int add = 1, devide = 0;

            while (num > 1) {
                if (num % 2 != 0) {
                    add++;
                    num--;
                    continue;
                }
                devide++;
                num /= 2;
            }

            return new int[] { add, devide };
        }
    }
}


/*
# Minimum Increment or Double Operations to Convert Array - Notes

## Problem

Start with an array of all zeros.

Allowed operations:

1. **Increment (+1)** any **one** element.
2. **Double (×2)** **every** element in the array at the same time.

Goal: Find the minimum number of operations to reach the target array.

---

# Key Observation

Instead of solving **forward**, solve **backward**.

Reverse operations are:

* `+1`  →  `-1`
* `×2`  →  `÷2`

Backward is easier because every step is almost forced.

---

# Backward Rules

## Rule 1: Odd Number

If an element is **odd**, the last operation **must** have been `+1`.

Reason:

* Doubling always produces an even number.
* Therefore an odd number cannot come from doubling.

Example:

```
7
↓
6   (-1)
```

Every odd element contributes **one increment operation**.

---

## Rule 2: Even Numbers

If **all non-zero elements are even**, then the last operation could have been a **global double**.

Undo it by dividing every element by 2.

Example:

```
[4,8]

↓

[2,4]
```

This counts as **one global double operation**.

---

# Why Add (+1) Operations?

Increment affects **only one element**.

Example:

```
+1 on first element

[1,0]

Second element does not change.
```

So every element pays its own cost.

Therefore,

```
Total increments = Sum of increments of every element
```

---

# Why Maximum of Double Operations?

Doubling affects **the whole array simultaneously**.

Example:

```
Double

[1,2]

↓

[2,4]
```

Both elements are doubled together.

You cannot double only one element.

Therefore, one double operation helps every element.

If one element needs 5 doubles and another needs 7 doubles,

you do NOT perform

```
5 + 7
```

double operations.

Instead,

perform

```
7
```

global doubles.

The element needing only 5 doubles is introduced later (its first `+1` happens later), so it experiences only the remaining doubles.

Therefore,

```
Total doubles = Maximum doubles required by any element
```

---

# Formula

```
Answer = Sum(All +1 operations)
       + Maximum(All double operations)
```

---

# Mental Model

## Local Operation

```
Increment one element
```

Think:

```
SUM
```

because every element pays separately.

---

## Global Operation

```
Double entire array
```

Think:

```
MAX
```

because one operation benefits every element together.

---

# Memory Trick

Whenever you see a problem, ask:

### Does this operation affect ONE element?

→ Add the costs.

```
SUM
```

### Does this operation affect EVERY element?

→ Share the cost.

```
MAX
```

---

# Example

Target:

```
[8,16]
```

Individual requirements:

```
8  → +1 = 1, Double = 3
16 → +1 = 1, Double = 4
```

Therefore,

```
Total +1 = 1 + 1 = 2

Total Doubles = max(3,4) = 4

Answer = 2 + 4 = 6
```

---

# Interview Intuition

**Local operations** cannot be shared.

```
Answer → SUM
```

**Global operations** are shared by everyone.

```
Answer → MAX
```

This "Local → SUM, Global → MAX" pattern appears in many algorithmic problems and is the key intuition behind this solution.





You're stuck because there is one hidden fact that nobody mentions.

The forward explanation is not the proof.

The proof is backward.

Let's prove it.

Consider
[8,16]

Go backwards.

8   16

Everything is even.

Divide whole array.

4   8        (1 divide)

Again

2   4        (2 divides)

Again

1   2        (3 divides)

Now first is odd.

Subtract 1.

0   2

Again everything non-zero is even.

Divide.

0   1        (4 divides)

Subtract.

0   0

Count

Subtracts = 2
Divides = 4

Answer

2+4=6
*/