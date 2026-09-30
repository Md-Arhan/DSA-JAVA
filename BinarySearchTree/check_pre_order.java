import java.util.List;
import java.util.Stack;

public class check_pre_order {
    class Solution {
        public boolean canRepresentBST(List<Integer> arr) {
            // code here
            Stack<Integer> st = new Stack<>();
            int last = Integer.MIN_VALUE;
            for (int ele : arr) {
                while (!st.isEmpty() && st.peek() < ele) {
                    last = st.pop();
                }
                if (last > ele)
                    return false;
                st.push(ele);
            }
            return true;
        }
    }

}



/*
 The while loop says is the par left subtree we have completed going to right side, then if my par of par is greater than me than i'm smaller
*/