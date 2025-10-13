package DP.MatrixChainMultiplication.StickCutting;

import java.util.Arrays;

public class Memoization {
    public int cutStick(int i, int j, int[] newCuts, int dp[][]){
        if(i + 1 == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

       for(int k = i+1; k < j; k++){
            int cut1 = cutStick(i, k, newCuts, dp);
            int cut2 = cutStick(k, j, newCuts, dp);
            int myCost = newCuts[j] - newCuts[i];
            int finalCost = cut1 + cut2 + myCost;
            
            ans = Math.min(ans, finalCost);
       }

       return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int newCuts[]  = new int[c+2];
        for(int i=0; i<c; i++){
            newCuts[i+1] = cuts[i];
        }
        newCuts[0] = 0;
        newCuts[c+1] = n;
        Arrays.sort(newCuts);

        int dp[][] = new int[c+2][c+2];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return cutStick(0, newCuts.length-1, newCuts, dp);
    }
}

/*
 * Imagine:
You're cutting a stick of length 7 at positions [1, 3, 4].

The full picture of the stick is:
[0]---[1]---[3]--[4]--------[7]
You're not just cutting between the cuts!
You're actually cutting the full stick: from 0 to 7.

If we don’t add 0 and n, we don’t know where the stick actually starts and ends — we would just be solving subproblems between cuts, without understanding that we're cutting the full segment from start to end.

✅ So we add 0 and n to represent the full stick boundaries.
 */


 /*
  * ✅ Why i + 1 == j is the correct base case
This means:
You're looking at a segment that has no cuts in between
(i.e., the subarray cuts[i+1] to cuts[j-1] is empty)
So no further cutting is needed
Return cost = 0
If you used:
if (i == j) return 0;
Then:
cuts[i] == cuts[j]
You're trying to cut a stick from a point to the same point, like cuts[2] to cuts[2]
That’s not a segment — that’s a point
❌ Doesn’t make sense to cut a stick of zero length'
if i dont do i+1 it wil cut infinite time
so my j coming is k which alrady made a cut then im checking in my actaual cuts array whether coming j is my donw cut
You are:
Trying to compute the minimum cost to cut the stick between cuts[i] and cuts[j]
You're looking for all possible cut positions k between i and j
These positions are already in the cuts[] array (after sorting and adding 0 and n)



Yes — exactly! You're on the right track now.

Let me refine your intuition and confirm what you're saying with clear language:
✅ Why i + 1 == j is the base case?
Because:
Between cuts[i] and cuts[j], you're only allowed to cut at positions cuts[i+1] to cuts[j-1].
If:
i + 1 == j
Then:
cuts[i+1] == cuts[j]
So cuts[i+1] does not exist in between cuts[i] and cuts[j]
There are no cuts possible in this segment
✅ Return 0 (no cost, no cut);


What you said:
"Basically i+1 because in my left scale cuts checking my actual cuts which starts from i+1"
✅ That’s correct.
Let’s rephrase and complete it for clarity:
"Basically i + 1 because when I'm solving cutStick(i, j), the possible cut positions (i.e., the values in my actual cuts[] array) are from cuts[i + 1] to cuts[j - 1]. If i + 1 == j, that range is empty, so no cuts can be made."

  */