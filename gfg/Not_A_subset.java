class Solution {
    public int findSmallest(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        int sum = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] > sum + 1){
                break;
            }
            sum+=arr[i];
        }
        
        return sum+1;
    }
}

/*
the ith elemet is greater tha sum + 1, then there is a gap. How? so if(1, 2, 3) sum = 6 it has subset till 6, if(the condition is false) then suppose arr[i] = 8 we cant make 7 from here. so return sum + 1;
*/