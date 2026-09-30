public class secret_cipher {
    class Solution {

        int[] constructZ(String s) {
            int n = s.length();
            int[] z = new int[n];

            int left = 0, right = 0;

            for (int i = 1; i < n; i++) {
                if (i <= right) {
                    z[i] = Math.min(right - i + 1, z[i - left]);
                }
                while (i + z[i] < n &&
                        s.charAt(z[i]) == s.charAt(i + z[i])) {
                    z[i]++;
                }
                if (i + z[i] - 1 > right) {
                    left = i;
                    right = i + z[i] - 1;
                }
            }

            return z;
        }

        public String compress(String s) {
            int n = s.length();
            int[] z = constructZ(s);

            // best[i] = best encrypted string for s[0...i-1]
            String[] best = new String[n + 1];
            best[0] = "";

            for (int i = 1; i <= n; i++) {

                // Add the current character normally
                String normal = best[i - 1] + s.charAt(i - 1);
                best[i] = normal;

                // Check whether the prefix of length i has equal halves
                if (i % 2 == 0) {
                    int half = i / 2;

                    // s[0...half-1] equals s[half...i-1]
                    if (z[half] >= half) {
                        String doubled = best[half] + "*";

                        // First minimize length; then lexicographically compare.
                        if (doubled.length() < best[i].length() ||
                                (doubled.length() == best[i].length() &&
                                        doubled.compareTo(best[i]) < 0)) {
                            best[i] = doubled;
                        }
                    }
                }
            }

            return best[n];
        }
    }
}


/*
STRING COMPRESSION USING Z-ALGORITHM + DP

Goal:
Compress a string using:

    XX → compress(X) + "*"

where both halves are identical.

Examples:
    "abab" → "ab*"
    "aaaa" → "a**"

Meaning of *:
    Repeat the string before * once.

--------------------------------------------------

z[i]:
Length of prefix matching the substring starting at i.

Use Z-array to check quickly:

    Are both halves of a prefix equal?

For a prefix of length i:

    half = i / 2

If:

    z[half] >= half

then:

    s[0 ... half-1] == s[half ... i-1]

So the prefix is:

    X + X

and can be compressed as:

    compress(X) + "*"

--------------------------------------------------

DP meaning:

    best[i] = best compressed representation
              of s[0 ... i-1]

    best[0] = ""

For each prefix length i:

1. Normal option:
   
    normal = best[i - 1] + s.charAt(i - 1)

   Meaning: append the current character normally.

2. Repetition option:

   Only if i is even:

       half = i / 2

       if z[half] >= half:
           doubled = best[half] + "*"

   Meaning:
       first half == second half
       so represent both halves by first-half compression + "*".

3. Choose the better option:

   - Shorter compressed string wins.
   - If both have the same length, lexicographically smaller string wins.

--------------------------------------------------

Core code logic:

    best[i] = best[i - 1] + s.charAt(i - 1);

    if (i % 2 == 0) {
        half = i / 2;

        if (z[half] >= half) {
            doubled = best[half] + "*";

            if doubled is shorter than best[i],
               OR same length but lexicographically smaller:
                best[i] = doubled;
        }
    }

--------------------------------------------------

Example: "abab"

    Z-array: [0, 0, 2, 0]

    best[0] = ""
    best[1] = "a"
    best[2] = "ab"
    best[3] = "aba"

At i = 4:
    half = 2
    z[2] = 2 >= 2

    "ab" == "ab"

    normal  = "abab"
    doubled = best[2] + "*"
            = "ab*"

    best[4] = "ab*"

Answer: "ab*"

--------------------------------------------------

Complexity:

    Z-array construction: O(n)
    DP loop: O(n)

Note:
    With normal Java String concatenation, practical runtime can be higher
    because strings are immutable. Conceptually, the algorithm is O(n).
*/