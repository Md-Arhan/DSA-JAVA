public class Balancing_With_Distinct_powers {
    class Solution {
        public boolean balancePan(int a, int b) {
            while (b > 0) {
                int rem = b % a;

                if (rem == 0 || rem == 1) {
                    b /= a;
                } else if (rem == a - 1) {
                    b = b / a + 1;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}


/*
BALANCING WITH DISTINCT POWERS

CONCEPT:
Signed Base-a Representation
(For a = 3, this is called Balanced Ternary.)

PROBLEM:
Available weights = 1, a, a², a³, ...
Each weight can be used at most once.

We need:
b + left weights = right weights

CORE IDEA:
Represent b using distinct powers of a, with each power
having coefficient -1, 0, or +1.

Example: a = 3, b = 5

5 = 9 - 3 - 1

Therefore:
5 + 3 + 1 = 9  →  true

WHY USE % AND / ?
b % a gives the remainder (current digit).
b / a moves to the next power (quotient).

THREE VALID REMAINDERS:

1. rem == 0
   Nothing to handle at the current power.
   b = b / a

2. rem == 1
   Use the current power positively.
   b = b / a

3. rem == a - 1
   Use the current power negatively.
   Since a - 1 = a + (-1), carry 1 to the next power.
   b = b / a + 1

4. Any other remainder
   Cannot represent that digit using -1, 0, +1.
   Return false.

CODE:

class Solution {
    public boolean balancePan(int a, int b) {
        while (b > 0) {
            int rem = b % a;

            if (rem == 0 || rem == 1) {
                b /= a;
            } else if (rem == a - 1) {
                b = b / a + 1;
            } else {
                return false;
            }
        }

        return true;
    }
}

EXAMPLE DRY RUN: a = 3, b = 5

b = 5 → rem = 5 % 3 = 2
2 == a - 1 → b = 5 / 3 + 1 = 2

b = 2 → rem = 2 % 3 = 2
2 == a - 1 → b = 2 / 3 + 1 = 1

b = 1 → rem = 1 % 3 = 1
b = 1 / 3 = 0

b = 0 → return true

MEMORY TRICK:
% → Check the current digit.
 / → Move to the next power.
+1 → Carry when remainder = a - 1.
Other remainder → Impossible.
 */



/*

BALANCING WITH DISTINCT POWERS — NOTES

1. KEY CONCEPT
Powers of a are:
1, a, a², a³, ...

Each power can be used at most once.
We represent each power using a coefficient:
+1 = use positively
-1 = use negatively
 0 = don't use

2. QUOTIENT AND REMAINDER

q = b / a
r = b % a

r tells us how to handle the current power.
q moves us to the next power.

We don't store powers like 1, 3, 9 separately.
Division processes them implicitly.

3. CODE LOGIC

if (rem == 0 || rem == 1) {
    b /= a;
}

Remainder 0 or 1:
Handle the current power normally.
No carry is needed.

else if (rem == a - 1) {
    b = b / a + 1;
}

Remainder a - 1:
Rewrite it as a - 1.
The -1 handles the current power.
The +1 carries to the next power.

else {
    return false;
}

Other remainders cannot be represented using
coefficients -1, 0, +1.

4. EXAMPLE: a = 3, b = 5

Powers: 1, 3, 9, 27, ...

Iteration 1:
b = 5
rem = 5 % 3 = 2
b = 5 / 3 + 1 = 2

Iteration 2:
b = 2
rem = 2 % 3 = 2
b = 2 / 3 + 1 = 1

Iteration 3:
b = 1
rem = 1 % 3 = 1
b = 1 / 3 = 0

Loop ends → true

Representation:
5 = 9 - 3 - 1

5 + 3 + 1 = 9

5. HOW ARE POWERS TRACKED?

They are NOT stored in an array or variable.

% a → checks the current digit.
 / a → moves to the next digit.
+ 1  → carries to the next power.

Each power is handled once because the algorithm
moves forward and never revisits previous powers.

MEMORY TRICK:
0 or 1       → Divide
a - 1        → Divide + 1
Anything else → False



For a = 5:
- a - 1 = 4 works because we can write 4 = 5 - 1.
- a - 2 = 3 doesn't work because we cannot make 3 using one 1 and one 5.
- a - 3 = 2 doesn't work because we cannot make 2 using one 1 and one 5.
Remember: We check a - 1 because we can turn it into the next weight minus the current weight. The other remainders can't be handled that way.

 */