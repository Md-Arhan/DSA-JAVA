package Arrays;

/*
 * Kadane’s Algorithm is an optimized approach for finding the maximum sum
 * of a contiguous subarray in an array of integers. It runs in O(n) time complexity
 * and uses a greedy approach with dynamic programming concepts.
 */

public class Kadans_Algorithm {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // Initialize max sum
        int currSum = nums[0]; // Start with first element
    
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
    
        return maxSum;
    }

    public int kadens(int temp[]){
        int CurrSum = temp[0];
        int maxSum = temp[0];
        int n = temp.length;
        
        for(int i=1; i<n; i++){
            // CurrSum = Math.max(temp[i], CurrSum + temp[i]);
            // maxSum = Math.max(maxSum, CurrSum);
            if(CurrSum + temp[i] < temp[i]){
                CurrSum = temp[i];
            }else{
                CurrSum += temp[i];
            }

            if(maxSum < CurrSum){
                maxSum = CurrSum;
            }else{
                maxSum = maxSum;
            }
        }
        
        return maxSum;
    }
    
    // public int maxRectSum(int mat[][]) {
    //     // code here
        
    //     int ans = Integer.MIN_VALUE;
    //     int r = mat.length;
    //     int c = mat[0].length;
        
    //     for(int i=0; i<r; i++){
    //         int temp[] = new int[c];
    //         for(int j=i; j<r; j++){
    //             for(int k=0; k<c; k++){
    //                 temp[k]+=mat[j][k];
    //             }
    //             int aux = kadens(temp, c);
    //             ans = Math.max(aux, ans);
    //         }
    //     }
        
    //     return ans;
    // }

     public static void main(String args[]){
        Kadans_Algorithm obj = new Kadans_Algorithm();
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.kadens(nums));
    }
}


/*
 * nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
i	nums[i]   currSum (max(nums[i], currSum+nums[i]))	  maxSum (max(maxSum, currSum))
0	-2	        -2                                          	-2
1	1	        max(1, -2 + 1) = 1	                        max(-2, 1) = 1
2	-3	        max(-3, 1 + (-3)) = -2	                    max(1, -2) = 1
3	4	        max(4, -2 + 4) = 4	                         max(1, 4) = 4
4	-1	        max(-1, 4 + (-1)) = 3	                    max(4, 3) = 4
5	2	        max(2, 3 + 2) = 5	                        max(4, 5) = 5
6	1	        max(1, 5 + 1) = 6	                       max(5, 6) = 6
7	-5	        max(-5, 6 + (-5)) = 1               	  max(6, 1) = 6
8	4	        max(4, 1 + 4) = 5	                      max(6, 5) = 6
 */