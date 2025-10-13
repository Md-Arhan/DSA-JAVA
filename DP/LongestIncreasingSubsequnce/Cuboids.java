package DP.LongestIncreasingSubsequnce;

import java.util.Arrays;

public class Cuboids {

    public int dpApproch(int boxex[][]){
        int[] dp = new int[boxes.size()];
        
        int ans = 0;
        
        // Check for all boxes starting as base.
        for (int i = boxes.size() - 1; i >= 0; i--) {
            dp[i] = boxes.get(i)[2];
            
            for (int j = i + 1; j < boxes.size(); j++) {
                if (boxes.get(i)[0] > boxes.get(j)[0] && 
                    boxes.get(i)[1] > boxes.get(j)[1]) {
                    dp[i] = Math.max(dp[i], boxes.get(i)[2] + dp[j]);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int stacking(int i, int dimensions[][], int dp[]){
        if(dp[i] != -1){
            return dp[i];
        }
        
        int ans = dimensions[i][2];
        
        for(int j=i+1; j<dimensions.length; j++){
             if (dimensions[j][0] < dimensions[i][0] && dimensions[j][1] < dimensions[i][1]) {
                ans = Math.max(ans, dimensions[i][2] + stacking(j, dimensions, dp));
            }
        }
        
        return dp[i] =  ans;
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length) {
        // Code here
        int n = height.length;
        
        int dimensions[][] = new int[n * 6][3];
        int idx = 0;
        
        for(int i=0; i<n; i++){
            int a = height[i];
            int b = width[i];
            int c = length[i];
            
            dimensions[idx++] = new int[]{a , b, c};
            dimensions[idx++] = new int[]{a , c, b};
            dimensions[idx++] = new int[]{b , a, c};
            dimensions[idx++] = new int[]{b , c, a};
            dimensions[idx++] = new int[]{c , a, b};
            dimensions[idx++] = new int[]{c , b, a};
        }
        
        Arrays.sort(dimensions, (box1, box2) -> {
            if (box1[0] == box2[0]) {
                return Integer.compare(box1[1], box2[1]);
            }
            return Integer.compare(box2[0], box1[0]);
        });
        
        int ans = 0;
        
        int dp[] = new int[n*6];
        
        Arrays.fill(dp, -1);
        
        
        for(int i=0; i<dimensions.length; i++){
            ans = Math.max(ans, stacking(i, dimensions, dp));
        }
        
        return ans;
    }

    public int stacking1(int i, int boxes[][], int memo[]) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int ans = boxes[i][2];

        for (int j = i + 1; j < boxes.length; j++) {
            if (boxes[j][0] <= boxes[i][0] &&
                    boxes[j][1] <= boxes[i][1] &&
                    boxes[j][2] <= boxes[i][2]) {
                ans = Math.max(ans, boxes[i][2] + stacking1(j, boxes, memo));
            }
        }

        return memo[i] = ans;
    }

    public int maxHeight1(int[][] cuboids) {
        int n = cuboids.length;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            Arrays.sort(cuboids[i]);
        }

        //Sorting it into the order
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            if (a[1] != b[1])
                return b[1] - a[1];
            return b[2] - a[2];
        });

        int memo[] = new int[n * 6];
        int ans = 0;

        Arrays.fill(memo, -1);

        for (int i = 0; i < cuboids.length; i++) {
            ans = Math.max(ans, stacking1(i, cuboids, memo));
        }

        return ans;
    }
}



/*
 * Summary
Your function does:

Generate all orientations.

Sort them by base size.

Recursively compute max height using memoization.

Returns the maximum height of any stack starting with any base box.

This dry run validates the logic. Let me know if you want to visualize with a larger example or convert this to a bottom-up DP version.
 */