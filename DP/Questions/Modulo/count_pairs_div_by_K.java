package DP.Questions.Modulo;

public class count_pairs_div_by_K {
    class Solution {
        public int countKdivPairs(int[] arr, int k) {
            // code here
            int n = arr.length;
            HashMap<Integer, Integer> map = new HashMap<>();

            int ans = 0;

            for (int i = 0; i < n; i++) {
                int rem = arr[i] % k;
                int req = (k - rem) % k;

                ans += map.getOrDefault(req, 0);

                map.put(rem, map.getOrDefault(rem, 0) + 1);
            }

            return ans;

        }
    }
}
