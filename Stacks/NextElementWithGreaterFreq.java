public class NextElementWithGreaterFreq {
    class Solution {
        public ArrayList<Integer> nextFreqGreater(int[] arr) {
            // code here
            int n = arr.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(-1);
            }

            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && map.get(arr[i]) > map.get(arr[st.peek()])) {
                    ans.set(st.pop(), arr[i]);
                }
                st.push(i);
            }

            return ans;
        }
    }
}
