package DP;

class Solution {
    static int rec( int l , int r, int nums[], int dp[][])
    {
        if( l>r)
        {
             return 0;
        }
         if( dp[l][r]!=-1)
         {
              return dp[l][r];
         }
        
        int ans=0;
        
        for( int k=l;k<=r;k++)
        {
            // l .. k-1
            int p1= rec(l,k-1,nums,dp);
            // k+1.. r
            int p2= rec( k+1,r,nums,dp);
            
            int val = nums[k];
            if( l-1>=0)
            {
               val= val* nums[l-1];
            }
            if( r+1<nums.length)
            {
               val= val* nums[r+1];
            }
            int cost = p1 + p2 +  val ;
            
             if( cost > ans)
             {
               ans= cost;
             }
        }
        dp[l][r]= ans;
        return ans;
    }
    public int maxCoins(int[] nums)
    {
        int n = nums.length;
        
        int dp[][]= new int[n][n];
        
        for( int i=0;i<n;i++)
        {
             for( int j=0;j<n;j++)
             {
               dp[i][j]=-1;
             }
        }
        
        return rec(0, n-1, nums, dp);
    }
}