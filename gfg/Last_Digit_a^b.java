public class Last_Digit_a^b {
    class Solution {

    public int getLastDigit(String a, String b) {

        if (b.equals("0")) {
            return 1;
        }

        int[][] arr = {
            {0},
            {1},
            {2, 4, 8, 6},
            {3, 9, 7, 1},
            {4, 6},
            {5},
            {6},
            {7, 9, 3, 1},
            {8, 4, 2, 6},
            {9, 1}
        };

        int v = a.charAt(a.length() - 1) - '0';

        int[] scan = arr[v];
        int size = scan.length;

        int rem = 0;

        for (int i = 0; i < b.length(); i++) {
            rem = (rem * 10 + (b.charAt(i) - '0')) % size;
        }

        if (rem == 0) {
            rem = size;
        }

        return scan[rem - 1];
    }
}
}
