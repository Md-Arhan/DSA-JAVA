package DP.Questions.Modulo;

public class check_subset_sum {
    class Solution {

        static boolean divisiblebyK(int[] arr, int k) {
            int n = arr.length;

            if (n > k)
                return true;

            // Stores achievable remainders modulo k
            boolean[] dp = new boolean[k];

            for (int i = 0; i < n; i++) {

                // Subset with divisible sum found
                if (dp[0])
                    return true;

                // New remainders formed using arr[i]
                boolean[] temp = new boolean[k];

                // Extend existing remainders
                for (int j = 0; j < k; j++) {
                    if (dp[j]) {
                        if (!dp[(j + arr[i]) % k])
                            temp[(j + arr[i]) % k] = true;
                    }
                }

                // Update dp with new remainders
                for (int j = 0; j < k; j++)
                    if (temp[j])
                        dp[j] = true;

                // Single element subset
                dp[arr[i] % k] = true;
            }

            return dp[0];
        }

        static final long MOD = 1000000007;

        public int countSubsequences(String s, int n) {

            long dp[] = new long[n];

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';

                long temp[] = new long[n];

                for (int k = 0; k < n; k++) {
                    if (dp[k] > 0) {
                        int newReminder = (k * 10 + digit) % n;

                        // Addint existing sequnce and current digit -> "12" + "3" = "123"
                        temp[newReminder] = (temp[newReminder] + dp[k]) % MOD;
                    }
                }

                // Create a new subsequence
                temp[digit % n] = (temp[digit % n] + 1) % MOD;

                // Merge the subsequence
                for (int k = 0; k < n; k++) {
                    // Keep the old sequence count seprate and add new sequence count
                    dp[k] = (dp[k] + temp[k]) % MOD;
                }
            }

            return (int) dp[0];
        }

        public boolean divisibleByK(int[] arr, int k) {
            // code here

            int n = arr.length;
            if (divisiblebyK(arr, k)) {
                return true;
            }

            return false;
        }
    }
}

// We have already found some subset whose remainder is x value, can i add my
// element to the subset or shall i create my new subset : the main concept

/*
 * Problem
 * 
 * We need to determine if there exists a subset whose sum is divisible by k.
 * 
 * For example,
 * 
 * arr = [2, 3, 7]
 * k = 5
 * 
 * Can we find a subset divisible by 5?
 * 
 * Yes.
 * 
 * 2 + 3 = 5
 * Brute Force Thinking
 * 
 * What would you normally do?
 * 
 * Generate every subset.
 * 
 * {}
 * {2}
 * {3}
 * {7}
 * {2,3}
 * {2,7}
 * {3,7}
 * {2,3,7}
 * 
 * Compute every sum.
 * 
 * This takes
 * 
 * O(2^n)
 * 
 * which is too slow.
 * 
 * Important Observation
 * 
 * Do we really care about the actual sum?
 * 
 * Suppose
 * 
 * k = 5
 * 
 * Look at these sums:
 * 
 * 5
 * 10
 * 15
 * 20
 * 25
 * 
 * All are divisible by 5.
 * 
 * Similarly,
 * 
 * 1
 * 6
 * 11
 * 16
 * 21
 * 
 * all leave remainder 1.
 * 
 * Likewise,
 * 
 * 2
 * 7
 * 12
 * 17
 * 
 * all leave remainder 2.
 * 
 * So instead of remembering
 * 
 * 5
 * 10
 * 15
 * 20
 * 
 * we only remember
 * 
 * remainder = 0
 * 
 * That's the key idea.
 * 
 * So what do we store?
 * 
 * Instead of saying
 * 
 * I can make sum = 17
 * 
 * we say
 * 
 * I can make remainder = 2
 * 
 * because
 * 
 * 17 % 5 = 2
 * 
 * Now there are only
 * 
 * 0
 * 1
 * 2
 * 3
 * 4
 * 
 * possible states.
 * 
 * Only k states!
 * 
 * Now suppose
 * 
 * Current remainders are
 * 
 * 0 1 2 3 4
 * 
 * F F T F F
 * 
 * Meaning
 * 
 * I can make remainder 2.
 * 
 * Now a new number arrives.
 * 
 * 8
 * 
 * What happens?
 * 
 * Current subset remainder
 * 
 * 2
 * 
 * Add
 * 
 * 8
 * 
 * New sum remainder
 * 
 * (2+8)%5
 * 
 * =10%5
 * 
 * =0
 * 
 * Wow!
 * 
 * Without knowing the actual sum,
 * 
 * we know we can now make
 * 
 * remainder 0
 * 
 * That's exactly this transition:
 * 
 * temp[(j + arr[i]) % k] = true;
 * 
 * where
 * 
 * j = old remainder
 * arr[i] = new element
 * Real Example
 * arr = [2,3]
 * k = 5
 * 
 * Initially
 * 
 * dp
 * 
 * 0 1 2 3 4
 * 
 * F F F F F
 * 
 * Take 2
 * 
 * Subset
 * 
 * {2}
 * 
 * Remainder
 * 
 * 2
 * 
 * Now
 * 
 * dp
 * 
 * F F T F F
 * 
 * Take 3
 * 
 * Already possible remainder
 * 
 * 2
 * 
 * Add 3
 * 
 * 2+3=5
 * 
 * 5%5=0
 * 
 * Now
 * 
 * dp
 * 
 * T F T T F
 * 
 * We reached
 * 
 * dp[0]
 * 
 * meaning
 * 
 * there exists a subset divisible by 5.
 * 
 * The real intuition
 * 
 * Imagine every subset carries only a remainder tag.
 * 
 * Instead of
 * 
 * Subset A → Sum = 37
 * 
 * we think
 * 
 * Subset A → Remainder = 2
 * 
 * When a new number comes,
 * 
 * it simply changes the tag.
 * 
 * Old tag = 2
 * 
 * Add 8
 * 
 * New tag = (2+8)%5
 * 
 * =0
 * 
 * That's all the DP is doing.
 * 
 * Why don't we store actual sums?
 * 
 * Suppose
 * 
 * arr = [1000,2000,3000,...]
 * 
 * The possible sums could be huge.
 * 
 * But the remainders are always just
 * 
 * 0
 * 1
 * 2
 * ...
 * k-1
 * 
 * So we compress thousands (or millions) of possible sums into only k states.
 */