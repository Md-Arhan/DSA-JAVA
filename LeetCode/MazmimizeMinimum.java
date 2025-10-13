import java.util.Arrays;

public class MazmimizeMinimum {
    public boolean can(int target, int arr[], int k){
        int count = 1;
        int last = arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] - last >= target){
                last = arr[i];
                count++;
                if(count >= k){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        
        int left = 0;
        int right = arr[n-1];
        int ans = 0;
        
        while(left <=right){
            int mid = left + (right - left) / 2;
            if(can(mid, arr, k)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return ans;
    }
}
