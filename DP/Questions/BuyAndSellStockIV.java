package DP.Questions;

public class BuyAndSellStockIV {
    public class practice_Session {

        public static int rec(int i, int buy, int txn, int prices[], int dp[][][], int n, int k) {

            if (i == n || txn == k) {
                return 0;
            }

            if (dp[i][buy][txn] != -1) {
                return dp[i][buy][txn];
            }

            int ans = 0;

            if (buy == 0) {
                int take = -prices[i] + rec(i + 1, 1, txn, prices, dp, n, k);
                int notTake = rec(i + 1, 0, txn, prices, dp, n, k);
                ans = Math.max(notTake, take);
            } else { // buy 1
                int sales = prices[i] + rec(i + 1, 0, txn++, prices, dp, n, k);
                int notSell = rec(i + 1, 1, txn, prices, dp, n, k);

                ans = Math.max(sales, notSell);
            }

            dp[i][buy][txn] = ans;
            return ans;
        }

        public int maxProfit(int[] prices, int k) {
            int n = prices.length;
            int dp[][][] = new int[n + 1][2][k + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int x = 0; x < 2; x++) {
                        dp[i][j][x] = -1;
                    }
                }
            }

            return rec(0, 0, 0, prices, dp, n, k);
        }

        public static void main(String[] args) {

        }
    }

}
