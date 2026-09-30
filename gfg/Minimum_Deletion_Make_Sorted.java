import java.util.ArrayList;
import java.util.List;

public class Minimum_Deletion_Make_Sorted {
    class Solution {
        int find(List<Integer> list, int num) {
            int ans = -1;
            int low = 0;
            int high = list.size() - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (list.get(mid) >= num) {
                    ans = mid;
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            return ans;
        }

        public int minDeletions(int[] arr) {
            // code here
            int n = arr.length;
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int num = arr[i];
                if (list.size() == 0 || list.get(list.size() - 1) < num) {
                    list.add(num);
                } else {
                    int idx = find(list, num);
                    list.set(idx, num);
                }
            }
            return n - list.size();
        }
    }

}



/*
  Intuition:

Traverse the array from left to right. If the current element is larger than the last element in the tails array, append it because it extends the longest increasing subsequence found so far.

If the current element is smaller, it breaks the current increasing chain. Instead of discarding it, use binary search to find the first element in tails that is greater than or equal to it and replace that element.

Why replace? Because a smaller tail is always better than a larger tail for a subsequence of the same length. It gives more opportunities for future elements to extend the subsequence. We are not preserving the actual subsequence—we are preserving the best possible tail for every subsequence length.

  If any number found like 2 4 7 present in array which computed from org not in sequence wise because 5 got replace with 4 before it was 5, if i added 8 at the end because 8 > 7 and the array ends. the array size will be 4. How?
  main intution, the 4 has taken the place of 5. So what if i let it 5 same not replace with 4. 5 can became the part of LIS and make a max LIS. Any how 5 is part of subsequence and 5 < 8 as part of indexing
*/