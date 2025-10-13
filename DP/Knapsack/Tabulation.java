package DP.Knapsack;

public class Tabulation {

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapSackTabulation(int val[],  int wt[], int w){
        int n = val.length;
        int dp[][] = new int[val.length+1][w+1];
        for(int i=0; i<dp.length; i++){     //0 th col
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++){   //0th row
            dp[0][j] = 0;
        }

        //Tabulation

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                int v = val[i-1];    //ith item val
                int weigh = wt[i-1]; // ith item wt
                if (weigh<=j) {
                    int incProfit = v + dp[i-1][j-weigh];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][w];
    }
    
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapSackTabulation(val, wt, W));
    }
}


/*
 * We use n + 1 so that:
We have space for the base case (0 items)
We include all n items in the iteration

i goes from 0 to n → that's n + 1 rows.
i = 0 → base case: no items selected
i = 1 to n → considering each of the n items
Thus, we need n + 1 rows to handle all n items + the base case.
 */


/*
 * So actually i-1 is my previous items and j-w is my remaining weight, for my remainig weight can i add previous elements
 */