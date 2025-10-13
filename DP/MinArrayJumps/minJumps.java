package DP.MinArrayJumps;

public class minJumps {
    public int minJumps(int[] arr) {
        // code here
        if(arr[0] == 0 ) return -1;
        int n = arr.length;
        int max = 0;
        int jumps = 0;
        int curridx = 0;
        
        for(int i=0; i<n; i++){
            if(i == arr.length-1) break;
            max = Math.max(max, i+arr[i]);
            if(i == curridx){
                jumps++;
                if (max <= i) return -1; 
                curridx = max;
            }
        }
        
        return jumps;
    }
}
