import java.util.HashSet;
import java.util.Set;

public class String_ContainsAllBinaryCode_of_size_K {
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> seen = new HashSet<>();

            for (int i = 0; i <= s.length() - k; i++) {
                seen.add(s.substring(i, i + k));

                if (seen.size() == (1 << k))
                    return true;
            }

            return false;
        }
    }
}


/*
   Problem says: There is a K, we need the k number enumeration should be exists in the form of substring in String s.

   k enumeration = 2^k, bcz binary of 0 and 1, examplem: 2^3 = 8 possible substring must exists in s.
*/