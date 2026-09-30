class Solution {
    
    public static int merge(int arr[], int mid, int i, int j){
        int temp[] = new int[j - i + 1];
        
        int left = i;
        int right = mid + 1;
        int k =0;
        int max = 0;
        
        while(left <= mid && right <= j){
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            }else{
                temp[k++] = arr[right++];
                
                max += (mid - left + 1);
            }
        }
        
        while(left <= mid){
            temp[k++] = arr[left++];
        }
        while(right <= j){
            temp[k++] = arr[right++];
        }
        
        for(int x=0; x<temp.length; x++){
            arr[i + x] = temp[x];
        }
        
        return max;
    }
    
    public static int solve(int i, int j, int arr[]){
        if(i >= j){
            return 0;
        }
        
        int mid = i + (j - i) / 2;
        
        int left = solve(i, mid, arr);
        int right = solve(mid + 1, j, arr);
        
        return merge(arr, mid, i, j) + left + right;
        
    }
    
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        
        return solve(0, n-1, arr);
        
    }
}

/*
Inversion array : If a bigger element comes before the smaller element called as Inversion.
i<j && arr[i] > arr[j]  
*/


// Q: substrings with more 1s than 0s

class Solution {
    
    
    static int merge(int left,int mid,int right,int[]prefix)
    {
        int i = left;
        int j = mid+1;
        
        ArrayList<Integer>arr = new ArrayList<>();
        int cnt =0;
        while(i<=mid&&j<=right){
            if(prefix[i]<prefix[j]){
                arr.add(prefix[i++]);
                cnt += right-j+1;
            }else{
                arr.add(prefix[j++]);
            }
        }
        
        while(i<=mid)arr.add(prefix[i++]);
        while(j<=right)arr.add(prefix[j++]);
        
        for(int k=left;k<=right;k++){
            prefix[k] = arr.get(k-left);
        }
        
        return cnt;
    }
    
    static int mergeSort(int i,int j,int[]prefix){
        
        if(i==j)return 0;
        
        int mid = (i+j)/2;
        
        int cnt =0;
        
        cnt += mergeSort(i,mid,prefix);
        cnt += mergeSort(mid+1,j,prefix);
        cnt += merge(i,mid,j,prefix);
        
        return cnt;
    }
    public int countSubstring(String s) {
        // code here
        int n = s.length();
        int[]prefix = new int[n+1];
        
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+(s.charAt(i)=='0'?-1:1);
        }
        
        return mergeSort(0,n,prefix);

    }
}