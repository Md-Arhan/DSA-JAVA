class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        int x = (int)(Math.log(n) / Math.log(2)) + 1;
        
        int i = 0;
        int j = x-1;
        
        while(i < j){
            
            if((n >> i & 1) != (n >> j & 1)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
};