public class MinimumSizeSubarraySum {

    public int minimum(int nums[], int target){
        int n = nums.length;
            // int prefix[] = new int[n];
            // prefix[0] = nums[0];
            // for(int i=1; i<n; i++){
            //     prefix[i] = prefix[i+1] + nums[i];
            //  }
            int i=0; int j = 0; int minLength = Integer.MAX_VALUE; int sum = 0;
        
            while(j < n){
                sum+=nums[j];
        
                while(i<n && sum>=target){
                    if(j-i+1 < minLength){
                        minLength = j-i+1;
                    }
        
                    sum-=nums[i];
                    i++;
                }
                j++;
            }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
