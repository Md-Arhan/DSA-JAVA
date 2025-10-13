package DP.Knapsack;
import java.util.Arrays;

public class Memoization {
    //O(n * w) in memoization
    public static int knapSack(int val[], int wt[], int w, int n, int dp[][]){
        if (w==0 || n==0) {
            return 0;
        }
        
        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n-1] <= w) {
            //include
            int ans1 =  val[n-1] + knapSack(val, wt, w-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapSack(val, wt, w, n-1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        }else{
            dp[n][w] =  knapSack(val, wt, w, n-1, dp);
            return dp[n][w];
        }
    }

    public static void main(String[] args) {
        int W = 7;
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int dp[][] = new int[val.length+1][W+1];
        Arrays.fill(dp, -1);

        System.out.println(knapSack(val, wt, W, wt.length, dp));
    }
}