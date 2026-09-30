class Solution {
    int maxSubstring(String s) {
        
        int currSum = 0;
        int maxSum = -1;
        
        for(int i = 0; i < s.length(); i++){
            
            int val;
            
            if(s.charAt(i) == '0'){
                val = 1;
            }else{
                val = -1;
            }
            
            currSum = Math.max(val, currSum + val);
            
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}