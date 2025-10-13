
import java.util.ArrayList;

//Knuth-Morris-Pratt (KMP)

public class KMP_Algorithmz {

    static void constructLps(String pat, int[] lps) {

        // len stores the length of longest prefix which
        // is also a suffix for the previous index
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {

            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // If there is a mismatch
            else {
                if (len != 0) {

                    // Update len to the previous lps value
                    // to avoid redundant comparisons
                    len = lps[len - 1];
                } else {

                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        // Pointers i and j, for traversing
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched
                // store the start index in result
                if (j == m) {
                    res.add(i - j); // j = 4 -1 = 3 aaba = 4;

                    // Use LPS of previous index to
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }

            // If there is a mismatch
            else {

                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        ArrayList<Integer> res = search(pat, txt);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }

}

/*
 * Input: txt = “abcab”, pat = “ab”
 * Output: [0, 3]
 * Explanation: The string “ab” occurs twice in txt, first occurrence starts
 * from index 0 and second from index 3.
 */

/*
 * KMP Pattern Searching Algorithm.
 * The Naive Algorithm can work in linear time if we know for sure that all
 * characters are distinct. Please refer Naive Pattern Searching for Distinct
 * Characters in Pattern. The Naive algorithm can not be made better than linear
 * when we have repeating characters.
 * 
 * Examples:
 * 
 * 1) txt[] = “AAAAAAAAAAAAAAAAAB”, pat[] = “AAAAB”
 * 2) txt[] = “ABABABCABABABCABABABC”, pat[] = “ABABAC” (not a worst case, but a
 * bad case for Naive)
 * 
 * 
 * The KMP matching algorithm uses degenerating property (pattern having the
 * same sub-patterns appearing more than once in the pattern) of the pattern and
 * improves the worst-case complexity to O(n+m).
 * 
 * The basic idea behind KMP’s algorithm is: whenever we detect a mismatch
 * (after some matches), we already know some of the characters in the text of
 * the next window. We take advantage of this information to avoid matching the
 * characters that we know will anyway match.
 */

/*
 * We preprocess the pattern and build LPS array for it. The size of this array
 * is same as pattern length.
 * LPS is the Longest Proper Prefix which is also a Suffix. A proper prefix is a
 * prefix that doesn’t include whole string. For example, prefixes of “abc” are
 * “”, “a”, “ab” and “abc” but proper prefixes are “”, “a” and “ab” only.
 * Suffixes of the string are “”, “c”, “bc”, and “abc”.
 * Each value, lps[i] is the length of longest proper prefix of pat[0..i] which
 * is also a suffix of pat[0..i].
 */