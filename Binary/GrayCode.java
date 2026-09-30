import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {
    class Solution {
        public ArrayList<String> graycode(int n) {
            // code here
            if (n == 1) {
                return new ArrayList<>(Arrays.asList("0", "1"));
            }

            ArrayList<String> ans = graycode(n - 1);

            ArrayList<String> res = new ArrayList<>();

            for (int i = 0; i < ans.size(); i++) {
                String val = "0" + ans.get(i);

                res.add(val);
            }

            for (int i = ans.size() - 1; i >= 0; i--) {
                String val = "1" + ans.get(i);

                res.add(val);
            }

            return res;
        }
    }
}



/*
 Gray code is binary number, which has only 1 bit differnce from it's adjacent
*/