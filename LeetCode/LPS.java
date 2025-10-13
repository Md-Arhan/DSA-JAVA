public class LPS {
    int getLPSLength(String s) {
        if(s.length() == 1){
            return 0;
        }
        int n = s.length();
        
        int pre = 0;
        int suff = 1;
        int count = 0;
        int pos = 1;
        int temp = 0;
        
        while(suff < n){
            if(s.charAt(pre) == s.charAt(suff)){
                pre++;
                suff++;
                count++;
            }else{
                // Reset prefix index
                pre = 0;
                count = 0;
                pos++;
                suff = pos;
            }
        }
        
        return count;
    }
}
