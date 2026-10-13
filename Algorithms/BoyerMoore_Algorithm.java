// package Arrays.Algorithms;
import java.util.*;

public class BoyerMoore_Algorithm {

    class BoyerMooreBadChar {

        // Build Bad Character table
        int[] buildBadChar(String pattern) {
            int[] last = new int[256+1]; // ASCII
            Arrays.fill(last, -1);

            for (int i = 0; i < pattern.length(); i++) {
                last[pattern.charAt(i)] = i; // store rightmost index
            }

            return last;
        }

        // Search using only Bad Character rule
        int search(String text, String pattern) {

            int n = text.length();
            int m = pattern.length();

            if (m == 0)
                return 0;

            int[] last = buildBadChar(pattern);

            int i = m - 1; // index in text
            int j = m - 1; // index in pattern

            while (i < n) {

                if (text.charAt(i) == pattern.charAt(j)) {
                    if (j == 0)
                        return i; // match found
                    i--; 
                    j--;
                } else {
                    int lo = last[text.charAt(i)];
                    int shift = Math.max(1, j - lo);

                    i += shift;
                    j = m - 1;
                }  
            }

            return -1; // not found
        }

        // demo
        // public static void main(String[] args) {
        //     BoyerMooreBadChar bm = new BoyerMooreBadChar();

        //     String text = "ABAAABCD";
        //     String pattern = "ABC";

        //     int idx = bm.search(text, pattern);

        //     System.out.println("Pattern found at index: " + idx);
        // }
    }

}

/*

Boyer–Moore string-search algorithm — searches for a pattern in text.

Compare the pattern from right to left. When a mismatch occurs, use the mismatching character to decide how far to shift the pattern instead of moving it just one position.

 Build the Bad Character table: Store the last occurrence of each character in the pattern.

 Start comparing from the right



BOYER–MOORE ALGORITHM — BAD CHARACTER RULE

KEY IDEA:
Yes, exactly! You're understanding it. Just remember one important detail: we align the pattern's lo position with the bad character's position in the text.
BEFORE SHIFT:

Remember: We don't want the difference to simply become positive. We want a shift that doesn't skip a possible match.
Your point is correct: the B at pattern index 3 has already matched the text's B at index 3.
However, lo is simply the rightmost occurrence of the bad character in the pattern. It doesn't track whether that occurrence matched earlier.
Since lo > j, we calculate:
shift = Math.max(1, j - lo);
shift = Math.max(1, 1 - 3); // 1

Because lo > j, the occurrence at lo is already behind us in the right-to-left comparison.
We don't move the pattern backward to align it there. Instead, the bad-character rule guarantees a forward shift of at least 1.
Memory trick: We've already compared positions to the right. We never shift the pattern backward; we only move forward safely.hift one position forward. The bad-character rule alone doesn't use the earlier matches to justify a larger shift; that is where the good-suffix rule can help.


Text:     X  X  X  B
Pattern:  A  B  C  D
            ↑        ↑
           lo=1     j=3 (mismatch)

lo = 1
j  = 3

shift = j - lo = 3 - 1 = 2


AFTER SHIFT (i += 2):

Text:           X  X  X  B
Pattern:              A  B  C  D
                         ↑
                        lo=1








HOW IT WORKS:

BOYER-MOORE (BAD CHARACTER RULE)

1. Compare the pattern with the text from RIGHT to LEFT.

2. If characters match, move left (i--, j--).

3. If characters mismatch:
   - The text character is called the BAD CHARACTER.
   - lo = rightmost position of that character in the pattern.
   - j = position where the mismatch happened.

4. Calculate the safe shift:
   shift = max(1, j - lo)

5. Why do we shift?
   - If the character exists before j, align it with j.
   - If the character doesn't exist (lo = -1),
     skip the entire pattern up to j + 1 positions.
   - If lo >= j, move at least 1 step.

6. After shifting, start comparing again from
   the RIGHTMOST character of the pattern.

MEMORY TRICK:
Mismatch → Find lo → Calculate shift → Move pattern
→ Start comparing from the right again.

MAIN IDEA:
Move as far as safely possible without skipping
a potential match.

Memory trick: If lo > j, don't use the occurrence to the right of the mismatch to justify a larger shift. Use max(1, j - lo) for the standard bad-character rule.
One correction: when j < lo, we move one step forward only if j - lo is zero or negative. Since j < lo means the difference is negative, Math.max(1, j - lo) gives 1.
 

 This logic answers one question:
 When a mismatch happens, how far can we safely shift the pattern?
 Instead of shifting only 1 step like naive search, Boyer–Moore uses information about the mismatched character to skip more text.

 When a mismatch occurs at pattern index j
 and the mismatched text character is x

 we look up:
 the last position of x inside the pattern

 If x appears earlier in the pattern,
 we align the pattern with that occurrence.

 If x does NOT appear in the pattern,
 we skip the entire pattern past that char.
*/