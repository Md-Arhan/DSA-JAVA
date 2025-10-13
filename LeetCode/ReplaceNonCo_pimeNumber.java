public class ReplaceNonCo_pimeNumber {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && gcd(st.peek(), nums[i]) != 1) {
                int top = st.pop();
                long lcm = ((long) top * nums[i]) / gcd(top, nums[i]);
                nums[i] = (int) lcm;
            }
            st.push(nums[i]);
        }

        return new ArrayList<>(st);
    }
}
