import java.util.ArrayList;

public class FartherSmallest {
    public int bs(int idx, int n, int suffix[], int arr[]){
        int si = idx+1;
        int ei = n-1;
        
        int res = -1;
        
        while(si <= ei){
            int mid = si + (ei - si) / 2;
            
            if(arr[suffix[mid]] < arr[idx]){
                res = suffix[mid];
                si = mid +1;
            }else{
                ei = mid -1;
            }
        }
        
        return res;
    }
    
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int suffix[] = new int[arr.length];
        suffix[n-1] = n-1;
        
        for(int i=n-2; i>=0; i--){
            if(arr[i] <= arr[suffix[i+1]]){
                suffix[i] = i; 
            }else{
                suffix[i] = suffix[i+1];
            }
        }
        
        for(int i=0; i<n; i++){
            int val = bs(i, n, suffix, arr);
            ans.add(val);
        }
        return ans;
    }
}
