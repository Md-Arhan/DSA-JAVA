class Solution {
    public String lexiString(String s) {
        // code here
        int n = s.length();
        int i = 0, j = 1, k = 0;

        // Two-pointer minimum rotation algorithm
        while (i < n && j < n && k < n) {
            char charI = s.charAt((i + k) % n);
            char charJ = s.charAt((j + k) % n);

            if (charI == charJ) {
                k++;
            } else {
                if (charI > charJ) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }

                // Keep the pointers distinct
                if (i == j) {
                    j++;
                }
                k = 0; // Reset matching prefix length
            }
        }

        // The smaller index marks the beginning of the optimal rotation
        int startPos = Math.min(i, j);

        // Reconstruct and return the rotated string
        return s.substring(startPos) + s.substring(0, startPos);
    }
}

// Booth algorithm for finding the lexicographically smallest rotation of a string

/*
Candidate i loses because its character is larger.
We skip the losing starting positions by moving i.
Now the new candidate at i is compared with the candidate at j again, starting from k = 0.


BOOTH'S STRING ALGORITHM — INTUITION NOTES

KEY IDEA:
Find the lexicographically smallest rotation of a string
by eliminating losing starting positions.

EXAMPLE:
s = "baca"

All possible rotations:
Index 0 → baca
Index 1 → acab
Index 2 → caba
Index 3 → abac

Smallest rotation = "abac"


1. SELECT TWO CANDIDATE SETS

   baca
   acab

   Compare characters from left to right.

   b > a

   INTUITION:
   "baca" loses because its first character is larger.
   Eliminate its losing starting positions.

   Remaining candidates:
   acab
   caba
   abac


2. COMPARE THE NEXT CANDIDATES

   acab
   caba

   a < c

   INTUITION:
   "caba" loses because its first character is larger.

   Remaining candidates:
   acab
   abac


3. COMPARE AGAIN

   acab
   abac

   First characters:
   a = a

   They match, so expand the comparison window.

   Next characters:
   c > b

   INTUITION:
   "acab" loses because its next character is larger.
   Eliminate its losing starting positions.

   Remaining candidate:
   abac

   FINAL ANSWER = "abac"


HOW THE CODE DOES THIS:

i = starting position of candidate 1
j = starting position of candidate 2
k = number of matching characters

IF charI == charJ:
    k++

    INTUITION:
    Characters match → expand the comparison window.

IF charI > charJ:
    i += k + 1

    INTUITION:
    Candidate i loses → skip its impossible starting
    positions and move to the next candidate.

IF charI < charJ:
    j += k + 1

    INTUITION:
    Candidate j loses → skip its impossible starting
    positions and move to the next candidate.

AFTER A MISMATCH:
    k = 0

    INTUITION:
    Start a fresh comparison between the new candidates.

IMPORTANT:
The algorithm does not explicitly create every rotation.
It uses i, j and k to eliminate losing starting positions.
Both i and j can move forward.

FINAL ANSWER:
    startPos = Math.min(i, j)

    return s.substring(startPos) + s.substring(0, startPos);


COMPLEXITY:
Time: O(n)
Auxiliary space: O(1)
Output string space: O(n)


MEMORY TRICK:
Select two candidates
        ↓
Match → Expand the window
        ↓
Mismatch → Eliminate the loser
        ↓
Reset k = 0
        ↓
Compare the next candidates
        ↓
Return the smallest rotation


How we can eliminate a set of string, because if a set of string is < other string, the larger can be elimated instantly because further it can't be the smallest the smallest coompare to it has already found. further the strin will be greater than that or leseer than that that can't be the smellest 

Elimating the existing set and moving to the next set when chI > chJ, chI moves to next set, and the chI now compares with chJ from Start

*/












/*
BOOTH'S STRING ALGORITHM — INTUITION NOTES

KEY IDEA:
Find the lexicographically smallest rotation of a string
without generating every rotation.

Example:
T1 = a c a b
T2 = a b a c

1. WHEN CHARACTERS MATCH
   If charI == charJ:
       k++

   INTUITION:
   Both candidates have the same character.
   We cannot eliminate either yet, so expand the
   comparison window and check the next character.

2. WHEN CHARACTERS DON'T MATCH

   CASE 1: charI > charJ

   Example:
   T1 = a c a b
        ↑
   T2 = a b a c
        ↑

   c > b, so T1 loses.

   i += k + 1

   INTUITION:
   T1 is lexicographically larger.
   Eliminate its losing starting positions because
   they cannot beat T2.

   CASE 2: charI < charJ

   T1 = a b a c
   T2 = a c a b

   b < c, so T2 loses.

   j += k + 1

   INTUITION:
   T2 is lexicographically larger.
   Eliminate its losing starting positions because
   they cannot beat T1.

3. WHY k + 1?
   k characters matched, but the next character differed.
   Skip the matched prefix and the mismatching position.
   This avoids checking every starting position separately.

4. AFTER A MISMATCH
   k = 0

   INTUITION:
   We are comparing new candidates, so start comparing
   their characters from the beginning.

5. FINAL ANSWER
   startPos = Math.min(i, j)

   Rotate the string from startPos.

   INTUITION:
   The smaller remaining valid starting index gives
   the lexicographically smallest rotation.

TIME COMPLEXITY: O(n)
A linear-time algorithm because losing starting positions
are eliminated instead of checking all rotations.

MEMORY TRICK:
Match → Expand window
Mismatch → Eliminate loser
k + 1 → Skip losing positions
Reset k → Start fresh comparison
Finish → Return smallest rotation




Important: It doesn't stop when it finds the smallest character. It stops when the algorithm has eliminated enough competing starting positions to identify the smallest rotation.
For example, abac and acab both start with a, but abac is smaller because the second character b comes before c. 


Booth's algorithm eliminates losing starting positions to find the lexicographically smallest rotation.
Remember the flow:
1. Characters match → Expand the comparison window (k++).
2. charI > charJ → Eliminate losing starting positions for i.
3. charI < charJ → Eliminate losing starting positions for j.
4. Repeat until the algorithm identifies the smallest rotation.
*/