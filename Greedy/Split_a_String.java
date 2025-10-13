package Greedy;

public class Split_a_String {
    
    public static int  maximumBalancedPartition(String str, int n){
        if(n==0){
         return 0;
        }
 
        int r = 0, l = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
         if(str.charAt(i) == 'R'){
             r++;
         }else{
             l++;
         }
 
         if(r==l){
             ans++;
         }
        }
 
        return ans;
 
     }
 
     public static void main(String[] args) {
         String str = "LRRRRLLRLLRL";
         int n = str.length();
         System.out.println(maximumBalancedPartition(str, n));
     }
}
