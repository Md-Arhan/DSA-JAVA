package DP.Questions;

import java.util.Arrays;

public class HouseRobber {
    public int thief(int n, int arr[], int isFirstRoobed, int isRobbed, int dp[][][]){
        if(n < 0){
            return 0;
        }
        
        if(isFirstRoobed == 1 && n == 0){
            return 0;
        }
        
        if(dp[n][isRobbed][isFirstRoobed] != -1){
            return dp[n][isRobbed][isFirstRoobed];
        }
        
        int max = 0;
        
        if(isRobbed == 0){
            int checker = (isFirstRoobed == 1 || n == 0 || n == arr.length -1) ? 1 : 0;
            int rob = arr[n] + thief(n-1, arr, checker, 1, dp);
            int skip = thief(n-1, arr, isFirstRoobed, 0, dp);
            
            max = Math.max(rob, skip);
        }else{
            int hold = thief(n-1, arr, isFirstRoobed, 0, dp);
            max = Math.max(hold, max);
        }
        
        return dp[n][isRobbed][isFirstRoobed] = max;
    }
    
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        
        int dp[][][] = new int[n][2][2];
        
        for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < dp[0].length; j++) {
            Arrays.fill(dp[i][j], -1);
           }
        }
        
        return thief(n-1, arr, 0, 0, dp);
    }

     public static int houseRobber(int num[], int n, int dp[]){
       if (n<0) {
        return 0;
       }
       if (n==0) {
        return num[0];
       }

       if (dp[n] != -1) {
          return dp[n];
       }

       // Two choices: Rob current house or skip it
       int rob = num[n] + houseRobber(num, n - 2, dp);  
       int skip = houseRobber(num, n - 1, dp);
       
       dp[n] = Math.max(rob, skip);  // Store the best result
       return dp[n];
    }

    static public class HouseRobber {

        /*
         * Final Dry Run Table
           House Index	nums[i]	Rob Current (nums[i] + prev2)	Skip Current (prev1)	Chosen Max (curr)	Updated prev2	Updated prev1
            0	2	-	-	2	-	-
            1	7	-	-	7	2	7
            2	9	9 + 2 = 11	7	11	7	11
            3	3	3 + 7 = 10	11	11	11	11
            4	1	1 + 11 = 12	11	12	11	12
           Final Answer: 12 ✅Final Dry Run Table
         */

        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0; 
            if (n == 1) return nums[0];
    
            int prev2 = nums[0];  // dp[i-2]
            int prev1 = Math.max(nums[0], nums[1]); // dp[i-1]
    
            for (int i = 2; i < n; i++) {
                int curr = Math.max(nums[i] + prev2, prev1);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }

    public static void main(String args[]){
        int num[] = {1, 2, 3, 1};
        int dp[] = new int[num.length+1];
        Arrays.fill(dp, -1);
        int n = num.length;
        System.out.println(houseRobber(num, n-1, dp));

        //Tabular
        HouseRobber hr = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + hr.rob(nums));


    }
}
