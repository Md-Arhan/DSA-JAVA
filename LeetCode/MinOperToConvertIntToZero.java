public class MinOperToConvertIntToZero {
    class Solution {
        public int minOperations(int[] nums) {
            List<Integer> s = new ArrayList<>();
            int res = 0;
            for (int a : nums) {
                while (!s.isEmpty() && s.get(s.size() - 1) > a) {
                    s.remove(s.size() - 1);
                }
                if (a == 0)
                    continue;
                if (s.isEmpty() || s.get(s.size() - 1) < a) {
                    res++;
                    s.add(a);
                }
            }
            return res;
        }
    }
}

/*
 * Here, if the previous element (top of stack) is greater than the current,
 * we pop it — meaning:
 * 
 * The current number is smaller, so any “higher layer” from before ends here.
 * 
 * Why?
 * Because the moment you hit a smaller number (a), the previous “subarray
 * height” can’t continue —
 * it’s like you hit a valley → end that subarray’s layer.
 * 
 * This keeps the stack increasing — meaning it only stores active heights in
 * sorted order.
 * 
 * 
 * 
 * if:
 * 
 * The stack is empty → this is a brand new non-zero segment, or
 * 
 * The current number a is higher than the last seen one → that means we’re
 * starting a new layer (we’ll need another operation to remove this height
 * later).
 */