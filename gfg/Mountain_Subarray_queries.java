class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;

        int[] up = new int[n];
        int[] down = new int[n];

        up[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                up[i] = up[i + 1];
            else
                up[i] = i;
        }

        down[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                down[i] = down[i + 1];
            else
                down[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<Boolean>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int peak = up[l];

            if (peak >= r || down[peak] >= r)
                ans.add(true);
            else
                ans.add(false);
        }

        return ans;
    }
}



/*
A simple way to remember it is:

up[i] = How far can I go to the right while the array is non-decreasing?
down[i] = How far can I go to the right while the array is non-increasing?

For a query [l, r]:

Start at l.

Jump to the end of the increasing part:

peak = up[l];

From that peak, see how far the decreasing part goes:

down[peak]
If it reaches r, it's valid.
peak = up[l];

if (peak >= r || down[peak] >= r)
    true;
else
    false;
Memory trick

"Climb first (up), then descend (down). If I can reach the end, answer is true."
*/