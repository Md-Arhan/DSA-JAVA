import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum3 {
    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> tripletList = Arrays.asList(nums[i], nums[j], nums[k]);
                            Collections.sort(tripletList);
                            if(!res.contains(tripletList)){
                               res.add(tripletList);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
}
