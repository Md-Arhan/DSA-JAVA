*class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F = 0;

        for(int i=0; i<n; i++){
           F+= i * nums[i];
           sum+=nums[i];
        }

        int ans = F;

        for(int i=1; i<n; i++){
            F+= sum - (n * nums[n - i]);
            ans = Math.max(ans, F);
        }

        return ans;
    }
}


/* Formula to take sum of rotational array multiply by indices : F[i] = F[i-1] + sum * (n * nums[n-i]) */