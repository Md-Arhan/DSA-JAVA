public class MakeAllElementsOfArray1 {
    
    class Solution {

    // Euclidean Algorithm (GCD)
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int overallGCD = nums[0];

        // Step 1: Find overall GCD of array
        for (int i = 1; i < n; i++) {
            overallGCD = gcd(overallGCD, nums[i]);
        }

        // If overall GCD > 1 → impossible
        if (overallGCD > 1) return -1;

        // Step 2: If we already have 1s in the array
        int ones = 0;
        for (int x : nums) if (x == 1) ones++;

        if (ones > 0) {
            // Need one operation for each non-1 element
            return n - ones;
        }
        
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    shortest = Math.min(shortest, j - i + 1);
                    break;
                }
            }
        }

        return (shortest - 1) + (n - 1);
    }
}
}

/*
 * Quick Intuition

Find if it’s possible → overallGCD = 1? ✅
If array already has 1s → just count how many non-1 elements → n - ones
If no 1s → find shortest subarray whose gcd = 1 → (length - 1) operations to get first 1
Then (n-1) more operations to make all elements 1
 */




/*
 * In hardware timing or signal processing,
if you have clocks running at frequencies [6 Hz, 10 Hz, 15 Hz],
the GCD of all frequencies is 1 Hz →
so you can synchronize all systems every 1 second.

Reducing all frequencies to 1 corresponds to “bringing all cycles to the same base unit.”


synchronizing ticks = finding a common interval where all clocks’ cycles line up, not forcing each tick to happen at the same time.


1 Hz = 1 tick per second → every 1 second, all clocks align.

Even though Clock A ticks 6 times, B 10 times, C 15 times in 1 second, at exactly 1 second, all of them have completed an integer number of ticks:
 */