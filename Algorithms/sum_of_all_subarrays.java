class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            sum += arr[i] * (i+1) * (n-i);
        }
        
        return sum;
    }
}

int[] nums = {3, 9, 2, 1, 7};
int n = nums.length;
int k = 3;

for (int i = 0; i < n; i++) {
    int count = Math.min(i, n - k)
              - Math.max(0, i - k + 1)
              + 1;

    System.out.println(nums[i] + " -> " + count);
}


/*
(i+1) states there are i+1 possible ways of starting position of array, n-i states there are n-i possible ways of ending posotion of array
Instead of generating every subarray, compute how much each element contributes to the final answer.
a single start index can grnerate n-1 subarrays, if any idx left behind multiply them with the n-1 indexs
*/