package DP.Knapsack.MinimumPartitioning;

public class Tabulationn {

    public static int minPartitioning(int arr[]) {
        int n = arr.length;
        int sum = 0;

        // Compute total sum
        for (int num : arr) {
            sum += num;
        }

        int w = sum / 2;
        int dp[][] = new int[n + 1][w + 1];

        // Bottom-up DP approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return Math.abs(sum1 - sum2);  // Fix: return |sum1 - sum2|
    }
    
    public static void main(String args[]){
        int numbers[] = {-36, 36};
        System.out.println(minPartitioning(numbers));
        
        
    }
}
