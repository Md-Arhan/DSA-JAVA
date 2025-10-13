import java.util.Arrays;

public class MaximumMedianWithKIncrement {
    public boolean can(int mid, int arr[], int k){
        int val = 0;
        int idx = 0;
        int half = arr.length/2;
        
        if(arr.length % 2 == 0){
            val+=mid*2 - (arr[half-1] + arr[half]);
        }else{
            val+=mid - arr[half];
        }
        
        for(int i=half+1; i<arr.length; i++){
            if(arr[i] < mid){
                val+= mid - arr[i];
            }
            
            if(val > k)return false;
        }
        
        return (val<=k);
    }
    
    public int maximizeMedian(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        Arrays.sort(arr);
        int left = arr[0];
        int right = arr[n-1] + k;
        
        int ans = 0;
        
        while(left <= right){
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
