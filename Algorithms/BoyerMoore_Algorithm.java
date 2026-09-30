package Arrays.Algorithms;

public class BoyerMoore_Algorithm {

    class BoyerMooreBadChar {

        // Build Bad Character table
        int[] buildBadChar(String pattern) {
            int[] last = new int[256]; // ASCII
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
                    int shift = m - Math.min(j, lo + 1);

                    i += shift;
                    j = m - 1;
                }
            }

            return -1; // not found
        }

        // demo
        public static void main(String[] args) {
            BoyerMooreBadChar bm = new BoyerMooreBadChar();

            String text = "ABAAABCD";
            String pattern = "ABC";

            int idx = bm.search(text, pattern);

            System.out.println("Pattern found at index: " + idx);
        }
    }

}

/*
 Bad Match logic: 
 
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