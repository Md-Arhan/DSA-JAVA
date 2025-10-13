public class LongestProperPeriodiic {
    int getLongestPrefix(String s) {
        // code here
        
         int i = s.length() - 1, j = 0, pos = s.length() - 1, cnt = 0;
         while (i > 0 && i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                i++;
            }
            else {
                j = 0;
                pos--;
                i = pos;
            }
        }
        
        if (i == 0) {
            return -1;
        }
        
        return pos;
    }
}


/*
 * Longest Periodic Proper Prefix  
  Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
  A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough times produces a string that starts with s.
 */