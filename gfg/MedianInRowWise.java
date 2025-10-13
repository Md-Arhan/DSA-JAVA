package gfg;

public class MedianInRowWise {
    static int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        // initializing the minimum and maximum values
        int min = Integer.MAX_VALUE, 
            max = Integer.MIN_VALUE;

        // iterating through each row of the matrix
        for (int i = 0; i < n; i++) {
          
            // updating the minimum value if current 
            // element is smaller
            if (mat[i][0] < min) 
              	min = mat[i][0];

            // updating the maximum value if current 
            // element is larger
            if (mat[i][m - 1] > max) 
              	max = mat[i][m - 1];
        }

        // calculating the desired position of the median
        int desired = (n * m + 1) / 2;

        // using binary search to find the median value
        while (min < max) {
          
            // calculating the middle value
            int mid = min + (max - min) / 2;

            // counting the number of elements less than 
            // or equal to mid
            int place = 0;
            for (int i = 0; i < n; i++) {
                place += upperBound(mat[i], mid);
            }

            // updating the search range based on the count
            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        // returning the median value
        return min;
    }

    // helper function to find the upper bound of a 
    // number in a row
    static int upperBound(int[] row, int num) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int mat[][] =  {{ 1, 3, 5 },
                        { 2, 6, 9 },
                        { 3, 6, 9 }};
        System.out.println(median(mat));
    }
}


/*
 * ✅ Problem Context
We are given an n x m matrix where each row is sorted in ascending order.
Goal: Find the median of all n * m elements.

✅ Key Idea
Instead of merging all rows or using extra space:
Use binary search on the value range (min to max in the matrix).
For each guess mid, count how many elements ≤ mid using upperBound on each row.
Narrow down the search space until min == max, which is the median.

✅ Steps
Find min & max:
min = smallest element in the matrix (first element of some row).
max = largest element in the matrix (last element of some row).
Binary search on value range [min, max]:
Calculate mid = (min + max) / 2.
Count place = number of elements ≤ mid across all rows.
If place < desired → median is bigger → move min up.
Else → median is smaller or equal → move max down.
When min == max, that's the median.



Matrix is row-wise sorted, so in each row we can find count of elements ≤ mid in O(log m) using binary search (upperBound).
We avoid flattening (O(n*m log(n*m))) and instead do:
 */