public class MinimumDaysToBloom {
    public boolean can(int mid, int arr[], int k, int m){
        int count = 0;
        int boq = 0;
        
        for(int val : arr){
            if(val <= mid){
                count++;
            }else{
                boq+=(count/k);
                count=0;
            }
        }
        
        boq+=(count/k);
        return boq>=m;
    }
    
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if(m > arr.length){
            return -1;
        }
        
        int left = Integer.MAX_VALUE;
        int right = 0;
        
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            left = Math.min(arr[i], left);
            right = Math.max(arr[i], right);
        }
        
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(can(mid, arr, k, m)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return ans;
    }
}
