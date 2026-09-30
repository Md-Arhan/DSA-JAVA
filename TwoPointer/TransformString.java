class Solution {
    int transform(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        int s1_count[] = new int[256];
        int s2_count[] = new int[256];
        
        for(int i=0; i<n; i++){
            s1_count[s1.charAt(i)]++;
        }
        for(int i=0; i<m; i++){
            s2_count[s2.charAt(i)]++;
        }
        
        
        for(int i=0; i<256; i++){
            if(s1_count[i] != s2_count[i]){
                return -1;
            }
        }
        
        int i = n-1;
        int j = m-1;
        int count = 0;
        
        while(i >=0 && j >= 0){
            if(s1.charAt(i) != s2.charAt(j)){
                count++;
                i--;
            }else{
                i--;
                j--;
            }
        }

        
        return count;
        
    }
}

/*
From the back, if characters match → move both.
If they don't match → the s1[i] character is the one being moved to the front, so move only i and increment the answer.
*/