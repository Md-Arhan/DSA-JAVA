class Solution {
    public static int solve(int dice, int sum, int m, int n, int x, int dp[][]){
        if(sum > x) return 0;
        
        if(dice == n){
            if(sum == x){
                return 1;
            }
            return 0;
        }
        
        if(dp[dice][sum] != -1){
            return dp[dice][sum];
        }
        
        int ways = 0;
        
        for(int face = 1; face <= m; face++){
            ways+= solve(dice+1, sum+face, m, n, x, dp);
        }
        
        return dp[dice][sum] = ways;
    }
    
    static int noOfWays(int m, int n, int x) {
        // code here
        int dp[][] = new int[n+1][x+1];
    
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }    
        
        return solve(0, 0, m, n, x, dp);
    }
};