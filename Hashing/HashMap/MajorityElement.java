package Hashing.HashMap;

import java.util.Set;

public class MajorityElement {
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            }else{
                map.put(curr, 1);
            }
            
            map.put(curr, map.getOrDefault(curr, 0) + 1);   //Short Hand
        }

        Set<Integer> keys = map.keySet();
        for (Integer num : keys /*map.keySet() [shortcut] */) {
            if (map.get(num) > n/3) {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        majorityElement(nums);

        int nums1[] = {1, 2};
        majorityElement(nums1);
    }
}
