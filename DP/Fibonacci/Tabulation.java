package DP.Fibonacci;

public class Tabulation {

    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String args[]){
        int n = 5;
        System.out.println(fibTabulation(n));
    }
}

/*
 * Even though the loop starts from 2, it still runs n - 1 times, which is linear in n.

Here’s a breakdown:
If n = 10, then the loop runs from i = 2 to i = 10.
That's 9 iterations — proportional to n.
Big-O notation ignores constants like “starts from 2” — it only cares about how the number of steps grows with n.
 */