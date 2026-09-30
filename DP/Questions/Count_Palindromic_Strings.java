package DP.Questions;

public class Count_Palindromic_Strings {
    class Solution {
        public int palindromicStrings(int n, int k) {
            final long MOD = 1000000007L;

            long ways = 1;
            long ans = 0;

            for (int len = 1; len <= Math.min(n, 2 * k); len++) {

                if (len % 2 == 1) {
                    // Odd length
                    int pairs = len / 2;

                    ans = (ans + ways * (k - pairs)) % MOD;

                } else {
                    // Even length
                    int pairs = len / 2;

                    ways = (ways * (k - pairs + 1)) % MOD;

                    ans = (ans + ways) % MOD;
                }
            }

            return (int) ans;
        }
    }
}


/*
PALINDROMIC STRINGS - NOTES

Given:
n = maximum length
k = number of available characters (a to kth letter)

Condition:
- String must be palindrome.
- Each character can appear at most 2 times.

KEY IDEA:
Don't build the whole palindrome.
Choose the left half + middle (if odd).
The right half is automatically fixed.

--------------------------------------------------

PAIRS:

pairs = len / 2

Every 2 positions form one mirrored pair.

len = 2 → AA       → 1 pair
len = 3 → ABA      → 1 pair + middle
len = 4 → ABBA     → 2 pairs
len = 5 → ABCBA    → 2 pairs + middle
len = 6 → ABCCBA   → 3 pairs

--------------------------------------------------

WHY CHARACTERS MUST BE DISTINCT:

Each pair makes a character appear exactly twice.

Example:
A B C C B A

A → 2 times
B → 2 times
C → 2 times

So we cannot use the same character for another pair.

--------------------------------------------------

WAYS:

ways = number of ways to choose DISTINCT characters for pairs.

Example k = 3:

1st pair → 3 choices
2nd pair → 2 choices
3rd pair → 1 choice

Therefore:

ways = 3 × 2 × 1

For even length:

ways = ways × (k - pairs + 1)

Why +1?

Because pairs means CURRENT pair number.

For 2nd pair:
already used = 1 character
available = k - 1
             = k - (pairs - 1)
             = k - pairs + 1

So:

1st pair → k
2nd pair → k - 1
3rd pair → k - 2

--------------------------------------------------

ODD LENGTH:

Example:

A B C B A

pairs = 5 / 2 = 2

A and B are already used in pairs.

Middle C must be different.

Middle choices:

k - pairs

So:

ans += ways × (k - pairs)

IMPORTANT:
ways is NOT updated for odd length.
Middle is only used for this particular length.

--------------------------------------------------

EVEN LENGTH:

Example:

A B B A

pairs = 4 / 2 = 2

For the current pair, choose a new unused character.

ways = ways × (k - pairs + 1)

Then:

ans += ways

--------------------------------------------------

EXAMPLE: k = 3

Length 1:
A
→ 3

Length 2:
AA, BB, CC
→ 3

Length 3:
ABA
→ 3 × 2 = 6

Length 4:
ABBA
→ AB, AC, BA, BC, CA, CB
→ 3 × 2 = 6

Total:
3 + 3 + 6 + 6 = 18

--------------------------------------------------

IMPORTANT:

For length 2:

aa, bb, cc
are palindromes.

ab, ac, ba, bc, ca, cb
are NOT palindromes.

But for length 4:

ab → abba
ac → acca
ba → baab
bc → bccb
ca → caac
cb → cbbc

So those 6 combinations become palindromes when mirrored.

--------------------------------------------------

MAXIMUM LENGTH:

Each of k characters can appear at most twice.

Maximum length = 2 × k

Therefore:

len <= Math.min(n, 2 * k)

--------------------------------------------------

CODE LOGIC:

for every len:

if odd:
    pairs = len / 2
    ans += ways × (k - pairs)

if even:
    pairs = len / 2
    ways *= (k - pairs + 1)
    ans += ways

--------------------------------------------------

MEMORY TRICK:

EVEN:
Choose a NEW PAIR
→ update ways

ODD:
Choose the MIDDLE
→ don't update ways

ways = pair combinations
pairs = len / 2
middle choices = k - pairs
maximum length = 2k




you choose one character first, the remaining choices are k - 1.
If I choose the first 2 characters, then there are k - 2 characters left. Why can't I just choose from those remaining characters?

You absolutely can. That's exactly what the formula is doing.   

if by "here" you mean ans, then YES. We add the result/ways for each length into ans.
*/
