import java.util.Arrays;

public class MinimumHeightDifference {
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
    
        int ans = arr[n - 1] - arr[0];
        for(int i=1; i<n; i++){
            int minVal = Math.min(arr[0]+k, arr[i] - k);
            int maxVal = Math.max(arr[n-1]-k, arr[i-1]+k);
            
            ans = Math.min(ans, maxVal - minVal);
        }
        
        return ans;
    }
}

/*
Every tower height in arr can be increased or decreased by k once (individually).
Find the smallest possible difference between the tallest and shortest tower after those changes.

Sorting gives you the heights in ascending order
h₀ ≤ h₁ ≤ … ≤ hₙ₋₁.
That makes it easy to reason about which towers you might raise and which you might lower.

Intuition: “one cut” strategy

If you imagine the sorted array laid out on a line, the best you can do is:

Raise some of the shorter towers by k (move them up).

Lower the remaining taller towers by k (move them down).

Why only one “cut”?
Because if you decided to raise something on the right and lower something on the left, you could always swap those choices to get an equal or smaller max–min difference.
So there’s always an optimal solution where all elements up to some index i-1 are increased and all elements from index i onward are decreased.
 */