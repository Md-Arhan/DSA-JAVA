package Arrays.Algorithms;

public class BoyerMoore_Algorithm {
    class AWQ {

        static int NO_OF_CHARS = 256;

        // A utility function to get maximum of two integers
        static int max(int a, int b) {
            return (a > b) ? a : b;
        }

        // The preprocessing function for Boyer Moore's
        // bad character heuristic
        static void badCharHeuristic(char[] str, int size,
                int badchar[]) {

            // Initialize all occurrences as -1
            for (int i = 0; i < NO_OF_CHARS; i++)
                badchar[i] = -1;

            // Fill the actual value of last occurrence
            // of a character (indices of table are ascii and
            // values are index of occurrence)
            for (int i = 0; i < size; i++)
                badchar[(int) str[i]] = i;
        }

        /*
         * A pattern searching function that uses Bad
         * Character Heuristic of Boyer Moore Algorithm
         */
        static void search(char txt[], char pat[]) {
            int m = pat.length;
            int n = txt.length;

            int badchar[] = new int[NO_OF_CHARS];

            /*
             * Fill the bad character array by calling
             * the preprocessing function badCharHeuristic()
             * for given pattern
             */
            badCharHeuristic(pat, m, badchar);

            int s = 0; // s is shift of the pattern with
                       // respect to text
            // there are n-m+1 potential alignments
            while (s <= (n - m)) {
                int j = m - 1;

                /*
                 * Keep reducing index j of pattern while
                 * characters of pattern and text are
                 * matching at this shift s
                 */
                while (j >= 0 && pat[j] == txt[s + j])
                    j--;

                /*
                 * If the pattern is present at current
                 * shift, then index j will become -1 after
                 * the above loop
                 */
                if (j < 0) {
                    System.out.println(
                            "Patterns occur at shift = " + s);

                    /*
                     * Shift the pattern so that the next
                     * character in text aligns with the last
                     * occurrence of it in pattern.
                     * The condition s+m < n is necessary for
                     * the case when pattern occurs at the end
                     * of text
                     */
                    // txt[s+m] is character after the pattern
                    // in text
                    s += (s + m < n) ? m - badchar[txt[s + m]]
                            : 1;
                }

                else
                    /*
                     * Shift the pattern so that the bad
                     * character in text aligns with the last
                     * occurrence of it in pattern. The max
                     * function is used to make sure that we get
                     * a positive shift. We may get a negative
                     * shift if the last occurrence of bad
                     * character in pattern is on the right side
                     * of the current character.
                     */
                    s += max(1, j - badchar[txt[s + j]]);
            }
        }

        /* Driver program to test above function */
        public static void main(String[] args) {

            char txt[] = "ABAAABCD".toCharArray();
            char pat[] = "ABC".toCharArray();
            search(txt, pat);
        }
    }
}




/*
 * Does s stay the same?
No! s keeps increasing as we shift the pattern to the right when mismatches occur.

How does s change?
Initially, s = 0
After a mismatch, we update s using the bad character heuristic.
Once we find a match, we shift s forward to check for another potential match.
Step-by-Step Shifts (s Values)
Initial Position (s = 0)
makefile
Copy code
txt:  ABAAABCD
pat:  ABC
       ↑
s = 0
Compare 'C' (pat[2]) with 'A' (txt[2]) → ❌ Mismatch
Shift using: s += max(1, j - badchar[txt[s + j]])
s += max(1, 2 - badchar['A'])
s += max(1, 2 - 0) = 2
New s = 2
Next Position (s = 2)
makefile
Copy code
txt:  ABAAABCD
pat:    ABC
         ↑
s = 2
Compare 'C' (pat[2]) with 'A' (txt[4]) → ❌ Mismatch
Shift using: s += max(1, j - badchar[txt[s + j]])
s += max(1, 2 - badchar['A'])
s += max(1, 2 - 0) = 2
New s = 4
Next Position (s = 4)
makefile
Copy code
txt:  ABAAABCD
pat:      ABC
           ↑
s = 4
Compare 'C' (pat[2]) with 'C' (txt[6]) → ✅ Match

Compare 'B' (pat[1]) with 'B' (txt[5]) → ✅ Match

Compare 'A' (pat[0]) with 'A' (txt[4]) → ✅ Match

Pattern found at s = 4 🎉

Now shift using:

java
Copy code
s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
s + m = 4 + 3 = 7
badchar[txt[7]] = badchar['D'] = -1
s += 3 - (-1) = 3 + 1 = 4
New s = 8 (out of bounds, so we stop)

Final Shift Values
Step	s Value
Start	0
Mismatch → Shift	2
Mismatch → Shift	4
Match Found 🎉	4
Shift After Match	8 (stop)
 */



/*
 * Boyer Moore
 * Pattern searching is an important problem in computer science. When we do search for a string in a notepad/word file, browser, or database, pattern searching algorithms are used to show the search results.

A typical problem statement would be- 

” Given a text txt[0..n-1] and a pattern pat[0..m-1] where n is the length of the text and m is the length of the pattern, write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m. “
 */