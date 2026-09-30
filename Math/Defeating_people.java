class Solution {
    int maxPeopleDefeated(int p) {
        long si = 1;
        long ei = p;
        int ans = 0;

        while (si <= ei) {
            long mid = si + (ei - si) / 2;

            long sum = mid * (mid + 1) * (2 * mid + 1) / 6;

            if (sum <= p) {
                ans = (int) mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return ans;
    }
}

/*
Formula to add sequential square sum = n * (n+1) * (2*n+1) / 6

*/