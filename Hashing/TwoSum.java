package Hashing;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = { 2, 7, 11, 15 };
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int curr = arr[i];
            int remainingSum = target - curr;

            // Check if the complement exists in the map
            if (map.containsKey(remainingSum)) {
                System.out.println(map.get(remainingSum) + ", " + i);
                return; // Exit once the pair is found
            }
            // Store the current value and its index in the map
            map.put(curr, i);
        }
    }
}
