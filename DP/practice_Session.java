package DP;

// import java.util.Arrays;

// import java.util.Arrays;

// import java.util.*;



/* Leet Code 714 */
//Buy and sell Stock with Transaction fee

// public class practice_Session {

//     public static int rec(int i, int buy, int prices[], int dp[][], int n, int fee){

//             if(i==n){
//                 return 0;
//             }
    
//             if (dp[i][buy] != -1) {
//                 return dp[i][buy];
//                         }
                
//             int ans = 0;
    
//                if (buy == 0) {
//                    int take = -prices[i] + rec(i+1, 1, prices, dp, n, fee);
//                    int notTake = rec(i+1, 0, prices, dp, n, fee);
//                 ans = Math.max(notTake, take);
//             }else{  //buy 1
//                 int sales = prices[i] - fee + rec(i+1, 0, prices, dp, n, fee);
//                 int notSell = rec(i+1, 1, prices, dp, n, fee);
                
//                 ans = Math.max(sales, notSell);
//             }
    
//             dp[i][buy] = ans;
//                 return ans;
//             }
        
//             public int maxProfit(int[] prices, int fee){
//                 int n = prices.length;
//                 int dp[][] = new int[n+1][2];
         
//                 for(int i=0; i<n; i++){
//                     for(int j=0; j<2; j++){
//                          dp[i][j] = -1;
//                      }
//                    }
        
//                 return rec(0, 0, prices, dp, n, fee);
//             }
                

//        public int maxProfit(int[] prices) {
//     int n = prices.length;
//     int[][] dp = new int[n + 1][2];

//     // dp[i][0] = max profit starting from day i when we can buy
//     // dp[i][1] = max profit starting from day i when we have already bought (can sell)

//     // Base Case: When i == n (past the last day), profit is 0
//     for (int i = n - 1; i >= 0; i--) {
//         for (int isbuy = 0; isbuy <= 1; isbuy++) {
//             if (isbuy == 0) {
//                 int buy = -prices[i] + dp[i + 1][1];     // Buy today
//                 int skip = dp[i + 1][0];                 // Skip buying today
//                 dp[i][isbuy] = Math.max(buy, skip);
//             } else {
//                 int sell = prices[i] + dp[i + 1][0];     // Sell today
//                 int hold = dp[i + 1][1];                 // Skip selling
//                 dp[i][isbuy] = Math.max(sell, hold);
//             }
//         }
//     }

//     return dp[0][0];  // Start at day 0 with option to buy
// }

//     public static void main(String args[]){

//     }
// }

/*
 * You only have 2 states per day:
i: from 0 to n → n values
isbuy: 0 or 1 → 2 values
And for each unique (i, isbuy), you compute once (thanks to memoization).
 */




//Buy and Sell Stocks with cool down

// public class practice_Session {

//     public static int rec(int i, int buy, int prices[], int dp[][], int n){

//                 // if(i==n){
//                 //     return 0;
//                 // }

//                 if (i >= n) {
//                     return 0;
//                 }
        
//                 if (dp[i][buy] != -1) {
//                     return dp[i][buy];
//                 }
        
//                 int ans = 0;
        
//                 if (buy == 0) {
//                     int take = -prices[i] + rec(i+1, 1, prices, dp, n);
//                     int notTake = rec(i+1, 0, prices, dp, n);
//                     ans = Math.max(notTake, take);
//                 }else{  //buy 1
//                     int sales = prices[i] + rec(i+2, 0, prices, dp, n);
//                     int notSell = rec(i+1, 1, prices, dp, n);
                    
//                     ans = Math.max(sales, notSell);
//                 }
        
//                 dp[i][buy] = ans;
//                 return ans;
//             }
        
//             public int maxProfit(int[] prices){
//                 int n = prices.length;
//                 int dp[][] = new int[n+1][2];
        
//                 for(int i=0; i<n; i++){
//                     for(int j=0; j<2; j++){
//                         dp[i][j] = -1;
                        
//                     }
//                 }
        
//                 return rec(0, 0, prices, dp, n);
//             }
        

//     public static void main(String[] args) {
        
//     }
// }




// WildCard Matching

public class practice_Session {


    public static void main(String[] args){

    }
}




