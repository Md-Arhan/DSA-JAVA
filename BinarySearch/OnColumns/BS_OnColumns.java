public class BS_OnColumns {
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int low = 0, high = m - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                // find the row index of the maximum element in mid column
                int maxRow = 0;
                for (int r = 1; r < n; r++) {
                    if (mat[r][mid] > mat[maxRow][mid]) {
                        maxRow = r;
                    }
                }

                int midVal = mat[maxRow][mid];

                int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
                int right = (mid + 1 < m) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

                // if current element is >= left & right → it's a peak
                if (midVal >= left && midVal >= right) {
                    return new int[] { maxRow, mid };
                }

                // move toward the larger neighbor
                if (left > midVal) {
                    high = mid - 1; // go left
                } else {
                    low = mid + 1; // go right
                }
            }

            return new int[] { -1, -1 }; // should not reach here if input valid
        }
    }

}
