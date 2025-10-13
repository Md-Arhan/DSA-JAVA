public class CountTriangle {
    public int countTriangles(int arr[]) {
        // code here
        int count = 0;
        Arrays.sort(arr);
        if(arr.length < 3){
            return 0;
        }
        
        int n = arr.length;
        
        for(int k=n-1; k>=2; k--){
            int i=0; int j = k-1;
            
            while(i<j){
                if(arr[i] + arr[j] > arr[k]){
                    count+=(j-i);
                    j--;
                }else{
                    i++;
                }
            }
        }
        
        return count;
    }
}