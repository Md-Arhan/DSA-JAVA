package TwoPointer;

public class MaximumConsecutive {

    public boolean can(int target, int arr[], int k){
        int count = 0;
        int n = arr.length;
        
        if(target > n){
            return false;
        }
        
        for(int i=0; i<target; i++){
            if(arr[i] == 0){
                count++;
            }
        }
        
        if(count <= k){
            return true;
        }
        
        for(int i=target; i<n; i++){
            if(arr[i] == 0) count++;
            if(arr[i-target] == 0) count--;
            if(count <= k){
                return true;
            }
        }
        
        return false;
    }

     public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zero = 0;
        int left = 0;
        int maxConsecutive = -1;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                zero++;
            }

            while(zero > k){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }

            maxConsecutive = Math.max(maxConsecutive, i - left+1);
        }

        return maxConsecutive;
    }

    public static void main(String[] args) {
        int right = k;
        int left = 0;
        int ans = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                right++;
            }
        }
        
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(can(mid, arr, k)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        System.out.println(ans);
    }
}
