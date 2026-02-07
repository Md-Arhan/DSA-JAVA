package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxOfMinOfEveryWindow {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> st = new Stack<>();

        // previous smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }

        // fill blanks: ensure answers are non-decreasing as window size decreases
        for (int k = n - 1; k >= 1; k--) {
            res[k] = Math.max(res[k], res[k + 1]);
        }

        // build and return answer list
        ArrayList<Integer> ans = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            ans.add(res[k]);
        }
        return ans; 
    }
}


/*

  1. Flip the Problem Around

Instead of asking:

“For each window size k, what’s the maximum of all the subarray minimums?”

ask:

“For each element in the array, how large a window can I make while keeping this element the smallest number in that window?”

If you know that for every element, you know everything.

 * 2. Each Element “Owns” a Window

Look at an element arr[i].
As you expand left and right from i, you stop when you hit a smaller element—because the moment you include something smaller, arr[i] is no longer the minimum.

So the span between the previous smaller and the next smaller element is the biggest subarray where arr[i] is guaranteed to be the minimum.
 */



/*
 * i	arr[i]	left[i]	right[i]	len	Update res[len]
0	10	-1	7	7	res[7] = max(0,10) = 10
1	20	0	4	3	res[3] = max(0,20) = 20
2	30	1	4	2	res[2] = max(0,30) = 30
3	50	2	4	1	res[1] = max(0,50) = 50
4	10	-1	7	7	res[7] = max(10,10) = 10
5	70	4	6	1	res[1] = max(50,70) = 70
6	30	4	7	2	res[2] = max(30,30) = 30
 */