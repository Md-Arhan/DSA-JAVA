class Solution {
    public int pairCount(int x, int y) {

        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        for (int p = 1; p * p <= n; p++) {

            if (n % p == 0) {

                int q = n / p;

                if (gcd(p, q) == 1) {
                    count += 2;
                }
            }
        }

        // when x == y, n = 1
        // (1,1)
        if (n == 1) {
            return 1;
        }

        return count;
    }
}


/*
PAIRS WITH GIVEN GCD AND LCM

Given:
x = GCD(a, b)
y = LCM(a, b)

Goal:
Count all ordered pairs (a, b) such that:
GCD(a,b) = x
LCM(a,b) = y


APPROACH:

1. GCD must divide LCM.

   If:
   y % x != 0

   return 0;


2. Remove the common GCD:

   n = y / x

   Example:
   x = 2
   y = 12

   n = 12 / 2 = 6


3. Find factor pairs of n.

   For n = 6:

   1 × 6
   2 × 3

   We only check up to √n:

   for (int p = 1; p * p <= n; p++)


4. Find the other factor:

   q = n / p

   Example:

   p = 1
   q = 6 / 1 = 6

   → (p,q) = (1,6)

   p = 2
   q = 6 / 2 = 3

   → (p,q) = (2,3)


5. Check if p and q are coprime:

   gcd(p,q) == 1

   Why?

   x is already the COMPLETE common factor.
   Therefore p and q cannot have another common factor.

   Example:

   gcd(1,6) = 1 ✅
   gcd(2,3) = 1 ✅


6. Each valid factor pair gives TWO answers.

   Because (a,b) and (b,a) are counted separately.

   (1,6) with x = 2:

   (1×2, 6×2) = (2,12)
   (6×2, 1×2) = (12,2)

   So count += 2


EXAMPLE:

x = 2
y = 12

n = y/x
  = 12/2
  = 6

Factor pairs:

1 × 6
2 × 3

Both have GCD = 1.

Convert using x = 2:

1 × 6 → (2,12), (12,2)
2 × 3 → (4,6),  (6,4)

Final pairs:

(2,12)
(12,2)
(4,6)
(6,4)

Answer = 4


CODE:

class Solution {
    public int pairCount(int x, int y) {

        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        for (int p = 1; p * p <= n; p++) {

            if (n % p == 0) {

                int q = n / p;

                if (gcd(p, q) == 1) {
                    count += 2;
                }
            }
        }

        if (n == 1) {
            return 1;
        }

        return count;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}


MEMORY TRICK:

GCD → common part

LCM / GCD → remove common part

Find factor pairs

Keep only coprime pairs

Each pair → ×2 because order matters


FLOW:

GCD = x
LCM = y
      ↓
n = y / x
      ↓
Find factor pairs of n
      ↓
gcd(p,q) == 1
      ↓
count += 2
*/