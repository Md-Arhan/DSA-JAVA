package Math;
public class FourDivisors {
    class Solution {
        public int sumFourDivisors(int[] nums) {
            int ans = 0;

            for (int val : nums) {
                int count = 0;
                int sum = 0;

                for (int d = 1; d * d <= val; d++) {

                    if (val % d == 0) {
                        int q = val / d;

                        // d is a divisor
                        count++;
                        sum += d;

                        // pair divisor
                        if (q != d) {
                            count++;
                            sum += q;
                        }

                        // more than 4 divisors → stop early
                        if (count > 4) {
                            break;
                        }
                    }
                }

                if (count == 4) {
                    ans += sum;
                }
            }

            return ans;
        }
    }
}


/*
✅ Correct understanding

We only loop up to √n, and for every divisor we find there:
the smaller divisor is d
the larger divisor (beyond √n) is n / d

So the divisors beyond √n are not separately checked —
they are automatically obtained as pair divisors.
 */
