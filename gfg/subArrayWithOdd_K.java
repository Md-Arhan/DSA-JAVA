public class subArrayWithOdd_K {
    class Solution {
        public int compute(int[] arr, int k) {
            int n = arr.length;
            int j = 0;
            int count = 0;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 != 0) {
                    count++;
                }
                while (count >= k) {
                    ans += (n - i);
                    if (arr[j] % 2 != 0) {
                        count--;
                    }
                    j++;
                }

            }

            return ans;
        }

        public int countSubarrays(int[] arr, int k) {
            // code here

            return compute(arr, k) - compute(arr, k + 1);
        }
    }
}
