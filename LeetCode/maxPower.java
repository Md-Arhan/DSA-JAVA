import java.util.Arrays;

public class maxPower {
    public long maxPower(int[] stations, int r, int k) {

        long low = 0;
        long high = Arrays.stream(stations).asLongStream().sum() + k;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, k, stations, r)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public boolean isPossible(long[] preCalc, int r, int k, int minimumRange) {
    int n = preCalc.length;
    long[] added = new long[n];  // how much extra power was added at position j
    long windowAdd = 0;          // sum of added[] that affects current index
    int remaining = k;

    for (int i = 0; i < n; i++) {
        // Remove influence that is out of range (i - (2*r+1))
        if (i - (2 * r + 1) >= 0) {
            windowAdd -= added[i - (2 * r + 1)];
        }

        // Effective power at i after previous additions
        long currentPower = preCalc[i] + windowAdd;

        if (currentPower < minimumRange) {
            long need = minimumRange - currentPower;
            if (need > remaining) return false;

            remaining -= need;

            // Place additional power at the furthest position that still affects i
            int pos = Math.min(n - 1, i + r);
            added[pos] += need;
            windowAdd += need;
        }
    }
    return true;
}

    public static boolean isPossible(long mid, long k, int[] st, int r) {
        long sum = 0;
        int n = st.length;

        long[] s = new long[n];
        for (int i = 0; i < n; i++)
            s[i] = st[i];

        for (int i = 0; i < r; i++) {
            sum += s[i];
        }
        for (int i = 0; i < n; i++) {
            if ((i + r) < n) {
                sum += s[i + r];
            }

            if ((i - (r + 1)) >= 0) {
                sum -= s[i - (r + 1)];
            }
            
            if (sum < mid) {
                if (mid - sum > k) {
                    return false;
                }
                int addPos = Math.min(n - 1, i + r);
                s[addPos] += (mid - sum);
                k -= (mid - sum);
                sum = mid;

            }
        }
        return true;
    }
}


/*
 We’ll start with the code’s key formula:

For each index i:

if (i+r<n) sum += s[i+r];     // add new right edge
if (i-(r+1)>=0) sum -= s[i-(r+1)]; // remove leftmost out-of-window
if (sum < mid) ... // try to fix deficit
Initialization
Before the loop, it does:

for (int i = 0; i < r; i++) sum += s[i];
Since r=1, that means:

sum = s[0] = 1
Loop starts

i = 0
Add right edge: 0+1=1 → sum += s[1]=2 → sum=1+2=3
Remove left edge: 0-2=-2 < 0 → skip
sum=3 < 5 → deficit = 2
deficit (2) <= k (2) → fix by adding 2 stations at i+r = 1.

Update:
s[1] += 2 → s[1]=4
k = 2 - 2 = 0
sum = mid = 5

i = 1
Add right edge: 1+1=2 → sum += s[2]=4 → sum = 5 + 4 = 9
Remove left edge: 1-2 = -1 < 0 → skip
sum = 9 ≥ 5 → OK.

i = 2
Add right edge: 2+1=3 → sum += s[3]=5 → sum = 9 + 5 = 14
Remove left edge: 2-2=0 → sum -= s[0]=1 → sum = 13
sum = 13 ≥ 5 → OK.

i = 3
Add right edge: 3+1=4 → sum += s[4]=0 → sum = 13 + 0 = 13
Remove left edge: 3-2=1 → sum -= s[1]=4 → sum = 9
sum = 9 ≥ 5 → OK.

i = 4
Add right edge: 4+1=5 (out of bounds) → skip
Remove left edge: 4-2=2 → sum -= s[2]=4 → sum = 5
sum = 5 ≥ 5 → OK.
Final: returns true;

 */




/*
 What your check / isPossible function does
For a given guess mid (minimum power you want every city to have):

Sliding window:
For each city i, you keep a running sum of power that affects city i.
This includes:

Existing stations in range [i-r, i+r]

Plus any new stations you’ve already “placed” in earlier steps.

Check if city i meets the goal:

If sum >= mid: good, move on.

If sum < mid:

Compute how many new stations are needed: need = mid - sum.

If need > k, fail (not enough stations left).

Otherwise:

Greedily place these stations at the farthest possible location (i + r, or the last city that can still help city i).

Subtract from k.

Update sum = mid because you just filled the deficit.

Slide the window:
After processing city i, you adjust the sum:
Remove the station that’s leaving the range.
Add the station that’s entering the range.
Also subtract any effect of previously placed extra stations when their influence moves out of range.
If you get to the end without failing, that mid is possible.
 */