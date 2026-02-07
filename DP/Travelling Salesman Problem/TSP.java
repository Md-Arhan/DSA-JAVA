package DP.Travelling Salesman Problem;

public class TSP {

    // Hamiltonian Cycle    
    class Solution {
    
    int visited_all;
    
    public int solve(int mask, int cost[][], int pos, int dp[][]){
        if(visited_all == mask){
            return cost[pos][0];
        }
        
        if(dp[mask][pos] != -1){
            return dp[mask][pos];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int city = 0; city<cost.length; city++){
            if((mask&(1<<city)) == 0){
               int newAns =
                cost[pos][city] +
                solve(mask | (1 << city), cost, city, dp);

                min = Math.min(min, newAns);
            }
        }
        
        return dp[mask][pos] = min;
    }
    
    public int tsp(int[][] cost) {
        // code here
        int n = cost.length;
        int dp[][] = new int[1<<n][n];
        
        for(int i=0; i<(1<<n); i++){
            Arrays.fill(dp[i], -1);
        }
        
        visited_all = (1<<n) - 1;
        
        return solve(1, cost, 0, dp);
    }
}
}


/*
Good — you’re thinking in the right direction 👍
Yes, in backtracking we do mark boolean values true, explore, and then mark them false when returning.

That part is correct.

But the problem is not about correctness of backtracking.

The problem is:

DP optimization requires recognizing that
two different recursion paths reached the same visited-set state.

A boolean array cannot do that reliably —
even if you reset values during backtracking.

Let’s see why.

🟢 First — What boolean[] works well for

This code is valid for brute-force TSP:

vis[i] = true;
dfs(nextCity);
vis[i] = false;


It correctly explores permutations.

So boolean array is OK for:

✔ Backtracking
✔ Generating all paths

But that is still exponential:

O(n!)


Because states repeat
and we compute them again and again.

Resetting booleans does not prevent re-computation.

🟥 Example that causes recomputation

Cities: 0,1,2

Two different paths reach the same state:

Path A: 0 → 1 → 2
Path B: 0 → 2 → 1


At the end, visited set is:

{0,1,2}


Both paths produce the same subproblem.

But look what happens:

Path A boolean array
[true, true, true]

Path B boolean array
[true, true, true]


They look the same —
but in recursion they are different objects in memory.

So DP cannot say:

this state already solved — reuse answer


Instead, it recomputes from scratch ❌

Resetting to false during return does NOT change this behavior —
because recomputation already happened.

🟢 What DP needs

Dynamic Programming needs a unique state key like:

(mask, currentCity)


Meaning:

which cities are visited
where I am now


Two equal states must map to the same key.

Boolean arrays cannot act as keys because:

arrays are mutable

comparison is by reference

identical contents ≠ same identity

So DP cannot store:

dp[booleanArray][pos]


Java literally forbids using arrays as map keys
(except by identity, which breaks memoization).

🟡 But when we convert boolean[] → number…

Example visited cities:

[true, false, true, false]


Convert to bitmask:

0101  (decimal 5)


Now both paths map to the same integer ✔

dp[5][pos]


DP recognizes the state and reuses it.

This is why bitmasking works.

🟣 Important clarification

You are right:

✔ boolean array + backtracking = correct
❌ boolean array + DP caching = cannot uniquely identify states

If we convert boolean[] into a value to memoize it…

…we have basically turned it into a bitmask anyway 🙂

🎯 Final takeaway

Resetting boolean values fixes traversal,
but it does not:

avoid recomputation

provide unique state identity

allow memoization

Bitmasking solves all three.
 */